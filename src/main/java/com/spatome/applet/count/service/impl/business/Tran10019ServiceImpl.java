package com.spatome.applet.count.service.impl.business;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.EnumUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.google.common.collect.HashBasedTable;
import com.google.common.collect.Table;
import com.spatome.applet.common.vo.BaseVO;
import com.spatome.applet.count.common.constants.RedisConstants;
import com.spatome.applet.count.common.enums.DateTypeEnum;
import com.spatome.applet.count.common.enums.ReportTypeEnum;
import com.spatome.applet.count.entity.ActivityCount;
import com.spatome.applet.count.entity.ActivityCountItem;
import com.spatome.applet.count.service.TranService;
import com.spatome.applet.count.service.impl.BaseService;
import com.spatome.applet.count.vo.ActivityCountReportVO;
import com.spatome.applet.count.vo.charts.LineVO;
import com.spatome.applet.count.vo.charts.PieVO;
import com.spatome.applet.util.DUtil;
import com.spatome.applet.util.SUtil;

import lombok.extern.slf4j.Slf4j;

/** 
 * 活动
 * 
 * 报表
 */
@Service
@Slf4j
public class Tran10019ServiceImpl extends BaseService implements TranService {

	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	@Transactional
	public Object execute(Map<String, String> request, HttpServletRequest req, HttpServletResponse res) {
		BaseVO<ActivityCountReportVO> result = new BaseVO<ActivityCountReportVO>();
		ActivityCountReportVO VO = new ActivityCountReportVO();
		result.setBody(VO);

		log.debug("获取参数");
		String activityId = request.get("activityId");
		String dateType = request.get("dateType");
		String reportType = request.get("reportType");
		log.debug("检查参数");
		Map<String, String> paramMap = new HashMap<String, String>();
		paramMap.put("activityId", activityId);
		paramMap.put("dateType", dateType);
		paramMap.put("reportType", reportType);
		super.checkNotEmpty(paramMap);

		log.debug("===========================业务处理=========================");
		if(!EnumUtils.isValidEnum(DateTypeEnum.class, dateType)){
			result.setCodeMessage("9999", "date类型未定义");
			return result;
		}

		ActivityCount record = daoFactory.getActivityCountMapper().selectByPrimaryKey(Long.valueOf(activityId));
		if(record==null){
			result.setCodeMessage("9999", "活动不存在");
			return result;
		}

		VO.setActivityId(Long.valueOf(activityId));
		VO.setActivityName(record.getActivityName());
		VO.setDateType(dateType);
		VO.setReportType(reportType);

		if(DateTypeEnum.A.name().equals(dateType) && ReportTypeEnum.B.name().equalsIgnoreCase(reportType)){
			this.dateType_A_B(record, VO);
		}else if(DateTypeEnum.H.name().equals(dateType) && ReportTypeEnum.X.name().equalsIgnoreCase(reportType)){
			this.dateType_H_X(record, VO);
		}else if(DateTypeEnum.D.name().equals(dateType)){
			this.dateType_D(record, VO);
		}else{
			result.setCodeMessage("9999", "功能暂未开放");
			return result;
		}
		
		return result;
	}
	
	/**
	 * 全部
	 * 饼图
	 */
	private void dateType_A_B(ActivityCount record, ActivityCountReportVO<PieVO> VO){
		PieVO pieVO = new PieVO();
		VO.setData(pieVO);

		ActivityCountItem activityCountItemQ = new ActivityCountItem();
		activityCountItemQ.setActivityId(record.getId());
		List<ActivityCountItem> activityCountItemList = daoFactory.getActivityCountItemMapper().selectByBean(activityCountItemQ);
		for (ActivityCountItem f : activityCountItemList) {
			PieVO.Item itemVO = new PieVO.Item();
			pieVO.getList().add(itemVO);
			itemVO.setItemId(f.getId());
			itemVO.setName(f.getItemName());

			List<Object> objList = super.stringRedisTemplate.boundHashOps(RedisConstants.APPLET_COUNT_H+record.getId()+":"+f.getId()).values();
			long count = 0L;
			for (Object object : objList) {
				count += Long.valueOf((String)object);
			}
			itemVO.setData(SUtil.NTS(count));
		}
	}

	/**
	 * 小时
	 * 线图
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	private void dateType_H_X(ActivityCount record, ActivityCountReportVO VO){
		LineVO lineVO = new LineVO();
		VO.setData(lineVO);

		ActivityCountItem activityCountItemQ = new ActivityCountItem();
		activityCountItemQ.setActivityId(record.getId());
		List<ActivityCountItem> activityCountItemList = daoFactory.getActivityCountItemMapper().selectByBean(activityCountItemQ);

		//找出所有x轴项(小时)
		//取出值
		Set<Long> hSet = new TreeSet<Long>();
		Table<Long, Long, String> itemTable = HashBasedTable.create();	//itemId,小时,数量
		for (ActivityCountItem activityCountItem : activityCountItemList) {
			Map<Object, Object> objMap = super.stringRedisTemplate.boundHashOps(RedisConstants.APPLET_COUNT_H+record.getId()+":"+activityCountItem.getId()).entries();
			for (Map.Entry<Object, Object> entry : objMap.entrySet()) {
				Long hours = Long.valueOf((String)entry.getKey());
				hSet.add(hours);
				itemTable.put(activityCountItem.getId(), hours, (String)entry.getValue());
			}			
		}
		List<Long> categoriesList = this.getAllHours(hSet);
		Set<Long> categoriesSet = new HashSet<Long>();
		for (Long v : categoriesList) {
			categoriesSet.add(v);
			//设置横项
			lineVO.getCategories().add(SUtil.NTS(v));
		}

		//组装要返回的值
		for (ActivityCountItem item : activityCountItemList) {
			LineVO.Item itemVO = new LineVO.Item();
			lineVO.getList().add(itemVO);
			itemVO.setItemId(item.getId());
			itemVO.setName(item.getItemName());
			for (Long hours : categoriesList) {
				if(itemTable.contains(item.getId(), hours)){
					itemVO.getData().add(itemTable.get(item.getId(), hours));
				}else{
					itemVO.getData().add("0");
				}
			}
		}
	}

	/**
	 * 天
	 */
	private void dateType_D(ActivityCount record, ActivityCountReportVO VO){
//		ActivityCountReportVO.SplitItem splitVO = new ActivityCountReportVO.SplitItem();
//		VO.getSplitList().add(splitVO);
//		ActivityCountItem activityCountItemQ = new ActivityCountItem();
//		activityCountItemQ.setActivityId(record.getId());
//		List<ActivityCountItem> activityCountItemList = daoFactory.getActivityCountItemMapper().selectByBean(activityCountItemQ);
//		for (ActivityCountItem f : activityCountItemList) {
//			ActivityItemVO itemVO = new ActivityItemVO();
//			itemVO.setItemId(f.getId());
//			itemVO.setItemName(f.getItemName());
//			itemVO.setCount(SUtil.NTS(f.getId()));
//			splitVO.getItemList().add(itemVO);
//		}
	}

	private List<Long> getAllHours(Set<Long> set){
		List<Long> result = new ArrayList<Long>();

		if(set==null || set.size()==0){
			return result;
		}

		List<Long> tmpList = new ArrayList<Long>(set);
		Date beginDate = DUtil.parseOrderFormat(String.valueOf(tmpList.get(0)));
		Date endDate = DUtil.parseOrderFormat(String.valueOf(tmpList.get(tmpList.size()-1)));
		result = DUtil.getHoursListBetweenDates(beginDate, endDate);

		return result;
	}
}
