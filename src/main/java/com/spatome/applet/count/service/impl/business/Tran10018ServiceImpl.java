//package com.spatome.applet.count.service.impl.business;
//
//import java.util.HashMap;
//import java.util.Map;
//
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//
//import org.springframework.stereotype.Service;
//import org.springframework.transaction.annotation.Transactional;
//
//import com.spatome.applet.common.constants.RedisConstants;
//import com.spatome.applet.entity.ActivityZj;
//import com.spatome.applet.service.TranService;
//import com.spatome.applet.service.impl.BaseService;
//import com.spatome.applet.util.business.ZjUtil;
//import com.spatome.applet.vo.BaseVO;
//
//import lombok.extern.slf4j.Slf4j;
//
///** 
// * 活动抓阄
// * 
// * 抓
// */
//@Service
//@Slf4j
//public class Tran10018ServiceImpl extends BaseService implements TranService {
//
//	@Override
//	@Transactional
//	public Object execute(Map<String, String> request, HttpServletRequest req, HttpServletResponse res) {
//		BaseVO<Object> result = new BaseVO<Object>();
//
//		log.debug("获取参数");
//		String activityId = request.get("activityId");
//		String userId = request.get("userId");
//		log.debug("检查参数");
//		Map<String, String> paramMap = new HashMap<String, String>();
//		paramMap.put("activityId", activityId);
//		paramMap.put("userId", userId);
//		super.checkNotEmpty(paramMap);
//
//		log.debug("===========================业务处理=========================");
//		ActivityZj record = daoFactory.getActivityZjMapper().selectByPrimaryKey(Long.valueOf(activityId));
//		if (record == null) {
//			result.setCodeMessage("9999", "活动不存在");
//			return result;
//		}
//
//		boolean isJoin = super.stringRedisTemplate.boundSetOps(RedisConstants.APPLET_ZJ_JOIN+activityId).isMember(userId);
//		if(isJoin){
//			result.setCodeMessage("9999", "您已参与,只能抽取一次！");
//			return result;
//		}
//
//		long totalCount = record.getTotalCount();			//总数
//		long totaldrawCount = record.getDrawCount();		//奖品数
//		long joinCount = super.stringRedisTemplate.boundSetOps(RedisConstants.APPLET_ZJ_JOIN+activityId).size();
//		long totalCountBalance = totalCount - joinCount;	//总剩余次数
//		if(totalCountBalance<=0){
//			result.setCodeMessage("9999", "已达抽取上限！");
//			return result;
//		}
//		long drawedCount = super.stringRedisTemplate.boundSetOps(RedisConstants.APPLET_ZJ_DRAWED+activityId).size();
//		long drawCountBalance = totaldrawCount - drawedCount;	//奖品余额
//
//		boolean isDrawed = ZjUtil.getInstance().draw(totalCountBalance, drawCountBalance);
//		super.stringRedisTemplate.boundSetOps(RedisConstants.APPLET_ZJ_JOIN+activityId).add(userId);
//		if(isDrawed){
//			super.stringRedisTemplate.boundSetOps(RedisConstants.APPLET_ZJ_DRAWED+activityId).add(userId);
//		}
//
//		result.setBody(isDrawed);
//
//		return result;
//	}
//}
