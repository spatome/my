//package com.spatome.applet.activity.service.impl.business;
//
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
//import com.spatome.applet.activity.common.constants.RedisConstants;
//import com.spatome.applet.activity.entity.ActivityCount;
//import com.spatome.applet.activity.entity.ActivityCountItem;
//import com.spatome.applet.activity.service.TranService;
//import com.spatome.applet.activity.service.impl.BaseService;
//import com.spatome.applet.activity.vo.ActivityCountHomeVO;
//import com.spatome.applet.activity.vo.ActivityItemVO;
//import com.spatome.applet.common.vo.BaseVO;
//import com.spatome.applet.util.SUtil;
//
//import lombok.extern.slf4j.Slf4j;
//
///** 
// * 活动抓阄
// * 
// * 我的业务活动
// */
//@Service
//@Slf4j
//public class Tran10014ServiceImpl extends BaseService implements TranService {
//
//	@Override
//	@Transactional
//	public Object execute(Map<String, String> request, HttpServletRequest req, HttpServletResponse res) {
//		BaseVO<ActivityCountHomeVO> result = new BaseVO<ActivityCountHomeVO>();
//		ActivityCountHomeVO VO = new ActivityCountHomeVO();
//		result.setBody(VO);
//
//		log.debug("获取参数");
//		String activityId = request.get("activityId");
//		log.debug("检查参数");
//		Map<String, String> paramMap = new HashMap<String, String>();
//		paramMap.put("activityId", activityId);
//		super.checkNotEmpty(paramMap);
//
//		log.debug("===========================业务处理=========================");
//		ActivityCount record = daoFactory.getActivityCountMapper().selectByPrimaryKey(Long.valueOf(activityId));
//		if(record==null){
//			result.setCodeMessage("9999", "活动不存在");
//			return result;
//		}
//		VO.setActivityId(record.getId());
//		VO.setActivityName(record.getActivityName());
//
//		ActivityCountItem activityCountItemQ = new ActivityCountItem();
//		activityCountItemQ.setActivityId(record.getId());
//		List<ActivityCountItem> itemList = daoFactory.getActivityCountItemMapper().selectByBean(activityCountItemQ);
//		for (ActivityCountItem f : itemList) {
//			ActivityItemVO itemVO = new ActivityItemVO();
//			itemVO.setItemId(f.getId());
//			itemVO.setItemName(f.getItemName());
//
//			List<Object> objList = super.stringRedisTemplate.boundHashOps(RedisConstants.APPLET_COUNT_H+activityId+":"+f.getId()).values();
//			long count = 0L;
//			for (Object object : objList) {
//				count += Long.valueOf((String)object);
//			}
//			itemVO.setCount(SUtil.NTS(count));
//
//			VO.getItemList().add(itemVO);
//		}
//		
//		return result;
//	}
//}
