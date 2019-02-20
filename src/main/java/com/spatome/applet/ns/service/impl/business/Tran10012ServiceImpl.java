//package com.spatome.applet.ns.service.impl.business;
//
//import java.util.HashMap;
//import java.util.Map;
//
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//
//import org.apache.commons.lang3.EnumUtils;
//import org.apache.commons.lang3.StringUtils;
//import org.springframework.stereotype.Service;
//import org.springframework.transaction.annotation.Transactional;
//
//import com.spatome.applet.common.vo.BaseVO;
//import com.spatome.applet.ns.common.enums.StatusEnum;
//import com.spatome.applet.ns.entity.Activity;
//import com.spatome.applet.ns.service.TranService;
//import com.spatome.applet.ns.service.impl.BaseService;
//
//import lombok.extern.slf4j.Slf4j;
//
///** 
// * 增删改查
// * 
// * 活动  
// * 修改
// */
//@Service
//@Slf4j
//public class Tran10012ServiceImpl extends BaseService implements TranService {
//
//	@Override
//	@Transactional
//	public Object execute(Map<String, String> request, HttpServletRequest req, HttpServletResponse res) {
//		BaseVO<Object> result = new BaseVO<Object>();
//
//		log.debug("获取参数");
//		String activityId = request.get("activityId");
//		String activityName = request.get("activityName");
//		String enterpriseName = request.get("enterpriseName");	//商家名称
//		String allowDayCount = request.get("allowDayCount");	//每天允许抽奖次数
//		String status = request.get("status");					//状态
//		log.debug("检查参数");
//		Map<String, String> paramMap = new HashMap<String, String>();
//		paramMap.put("activityId", activityId);
//		super.checkNotEmpty(paramMap);
//
//		log.debug("===========================业务处理=========================");
//		if(status!=null && !EnumUtils.isValidEnum(StatusEnum.class, status)){
//			result.setCodeMessage("9999", "状态未定义");
//			return result;
//		}
//		Activity activity = daoFactory.getActivityMapper().selectByPrimaryKey(Long.valueOf(activityId));
//		if(activity==null){
//			result.setCodeMessage("9999", "活动不存在");
//			return result;
//		}
//
//		Activity updateActivity = new Activity();
//		updateActivity.setId(activity.getId());
//		updateActivity.setActivityName(StringUtils.isBlank(activityName)?null:activityName);
//		updateActivity.setEnterpriseName(StringUtils.isBlank(enterpriseName)?null:enterpriseName);
//		updateActivity.setAllowDayCount(StringUtils.isBlank(allowDayCount)?null:Integer.valueOf(allowDayCount));
//		updateActivity.setStatus(StringUtils.isBlank(status)?null:status);
//		daoFactory.getActivityMapper().updateByPrimaryKeySelective(updateActivity);
//		
//		return result;
//	}
//}
