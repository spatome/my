package com.spatome.applet.count.service.impl.business;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.EnumUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.spatome.applet.common.vo.BaseVO;
import com.spatome.applet.count.common.enums.DateTypeEnum;
import com.spatome.applet.count.entity.ActivityCount;
import com.spatome.applet.count.entity.ActivityCountItem;
import com.spatome.applet.count.service.TranService;
import com.spatome.applet.count.service.impl.BaseService;
import com.spatome.applet.count.vo.ActivityCountReportVO;
import com.spatome.applet.count.vo.ActivityItemVO;
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

	@Override
	@Transactional
	public Object execute(Map<String, String> request, HttpServletRequest req, HttpServletResponse res) {
		BaseVO<ActivityCountReportVO> result = new BaseVO<ActivityCountReportVO>();
		ActivityCountReportVO VO = new ActivityCountReportVO();
		result.setBody(VO);

		log.debug("获取参数");
		String activityId = request.get("activityId");
		String dateType = request.get("dateType");
		log.debug("检查参数");
		Map<String, String> paramMap = new HashMap<String, String>();
		paramMap.put("activityId", activityId);
		paramMap.put("dateType", dateType);
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

		if(DateTypeEnum.A.name().equals(dateType)){
			this.dateType_A(record, VO);
		}else if(DateTypeEnum.H.name().equals(dateType)){
			this.dateType_H(record, VO);
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
	 */
	private void dateType_A(ActivityCount record, ActivityCountReportVO VO){
		ActivityCountReportVO.SplitItem splitVO = new ActivityCountReportVO.SplitItem();
		VO.getSplitList().add(splitVO);
		ActivityCountItem activityCountItemQ = new ActivityCountItem();
		activityCountItemQ.setActivityId(record.getId());
		List<ActivityCountItem> activityCountItemList = daoFactory.getActivityCountItemMapper().selectByBean(activityCountItemQ);
		for (ActivityCountItem f : activityCountItemList) {
			ActivityItemVO itemVO = new ActivityItemVO();
			itemVO.setItemId(f.getId());
			itemVO.setItemName(f.getItemName());
			itemVO.setCount(SUtil.NTS(f.getId()));
			splitVO.getItemList().add(itemVO);
		}
	}

	/**
	 * 小时
	 */
	private void dateType_H(ActivityCount record, ActivityCountReportVO VO){
		ActivityCountItem activityCountItemQ = new ActivityCountItem();
		activityCountItemQ.setActivityId(record.getId());
		List<ActivityCountItem> activityCountItemList = daoFactory.getActivityCountItemMapper().selectByBean(activityCountItemQ);
		for (ActivityCountItem activityCountItem : activityCountItemList) {
			
		}
		
		//super.redisTemplate.boundListOps(key)
		
		ActivityCountReportVO.SplitItem splitVO = new ActivityCountReportVO.SplitItem();
		VO.getSplitList().add(splitVO);

		for (ActivityCountItem f : activityCountItemList) {
			ActivityItemVO itemVO = new ActivityItemVO();
			itemVO.setItemId(f.getId());
			itemVO.setItemName(f.getItemName());
			itemVO.setCount(SUtil.NTS(f.getId()));
			splitVO.getItemList().add(itemVO);
		}
	}

	/**
	 * 天
	 */
	private void dateType_D(ActivityCount record, ActivityCountReportVO VO){
		ActivityCountReportVO.SplitItem splitVO = new ActivityCountReportVO.SplitItem();
		VO.getSplitList().add(splitVO);
		ActivityCountItem activityCountItemQ = new ActivityCountItem();
		activityCountItemQ.setActivityId(record.getId());
		List<ActivityCountItem> activityCountItemList = daoFactory.getActivityCountItemMapper().selectByBean(activityCountItemQ);
		for (ActivityCountItem f : activityCountItemList) {
			ActivityItemVO itemVO = new ActivityItemVO();
			itemVO.setItemId(f.getId());
			itemVO.setItemName(f.getItemName());
			itemVO.setCount(SUtil.NTS(f.getId()));
			splitVO.getItemList().add(itemVO);
		}
	}
}
