//package com.spatome.applet.activity.service.impl.business;
//
//import java.util.Date;
//import java.util.HashMap;
//import java.util.List;
//import java.util.Map;
//
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//
//import org.springframework.stereotype.Service;
//import org.springframework.transaction.annotation.Transactional;
//
//import com.spatome.applet.activity.entity.ActivityCount;
//import com.spatome.applet.activity.entity.ActivityCountItem;
//import com.spatome.applet.activity.service.TranService;
//import com.spatome.applet.activity.service.impl.BaseService;
//import com.spatome.applet.common.vo.BaseVO;
//import com.spatome.applet.util.convert.JUtil;
//
//import jodd.util.StringUtil;
//import lombok.extern.slf4j.Slf4j;
//
///** 
// * 统计
// * 基本增删改查
// * 
// * 增加
// */
//@Service
//@Slf4j
//public class Tran10010ServiceImpl extends BaseService implements TranService {
//
//	@Override
//	@Transactional
//	public Object execute(Map<String, String> request, HttpServletRequest req, HttpServletResponse res) {
//		BaseVO<Object> result = new BaseVO<Object>();
//
//		log.debug("获取参数");
//		String ownerNo = request.get("ownerNo");
//		String activityName = request.get("activityName");
//		String descs = request.get("descs");					//活动详情
//		String items = request.get("items");
//		log.debug("检查参数");
//		Map<String, String> paramMap = new HashMap<String, String>();
//		paramMap.put("ownerNo", ownerNo);
//		paramMap.put("activityName", activityName);
//		paramMap.put("items", items);
//		super.checkNotEmpty(paramMap);
//
//		Date date = new Date();
//		List<String> itemList = JUtil.toList(items, String.class);
//
//		log.debug("===========================业务处理=========================");
//		ActivityCount record = new ActivityCount();
//		record.setStatus("ON");
//		record.setCreateTime(date);
//		record.setUpdateTime(date);
//		record.setOwnerNo(ownerNo);
//		record.setActivityName(activityName);
//		record.setDescs(descs);
//		daoFactory.getActivityCountMapper().insertSelective(record);
//
//		for (String item : itemList) {
//			if(StringUtil.isBlank(item)){
//				continue;
//			}
//
//			ActivityCountItem activityCountItemQ = new ActivityCountItem();
//			activityCountItemQ.setActivityId(record.getId());
//			activityCountItemQ.setItemName(item);
//			daoFactory.getActivityCountItemMapper().insertSelective(activityCountItemQ);
//		}
//		
//		result.setBody(String.valueOf(record.getId()));
//
//		return result;
//	}
//}
