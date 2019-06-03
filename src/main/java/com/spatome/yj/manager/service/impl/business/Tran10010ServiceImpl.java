//package com.spatome.yj.manager.service.impl.business;
//
//import java.util.Date;
//import java.util.HashMap;
//import java.util.Map;
//
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//
//import org.springframework.stereotype.Service;
//import org.springframework.transaction.annotation.Transactional;
//
//import com.spatome.applet.activity.entity.Activity;
//import com.spatome.applet.common.vo.BaseVO;
//import com.spatome.yj.manager.common.enums.StatusEnum;
//import com.spatome.yj.manager.service.TranService;
//import com.spatome.yj.manager.service.impl.BaseService;
//
//import lombok.extern.slf4j.Slf4j;
//
///** 
// * 活动
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
//		String enterpriseName = request.get("enterpriseName");	//商家名称
//		String allowDayCount = request.get("allowDayCount");	//每天允许抽奖次数
//		log.debug("检查参数");
//		Map<String, String> paramMap = new HashMap<String, String>();
//		paramMap.put("ownerNo", ownerNo);
//		paramMap.put("activityName", activityName);
//		paramMap.put("enterpriseName", enterpriseName);
//		paramMap.put("allowDayCount", allowDayCount);
//		super.checkNotEmpty(paramMap);
//
//		Date date = new Date();
//
//		log.debug("===========================业务处理=========================");
//		Activity newActivity = new Activity();
//		newActivity.setStatus(StatusEnum.ON.name());
//		newActivity.setCreateTime(date);
//		newActivity.setUpdateTime(date);
//		newActivity.setOwnerNo(ownerNo);
//		newActivity.setActivityName(activityName);
//		newActivity.setEnterpriseName(enterpriseName);
//		newActivity.setAllowDayCount(Integer.valueOf(allowDayCount));
//		daoFactory.getActivityMapper().insertSelective(newActivity);
//		result.setBody(newActivity.getId());
//
//		return result;
//	}
//}
