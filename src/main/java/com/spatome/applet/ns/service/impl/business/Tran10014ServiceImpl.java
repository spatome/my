//package com.spatome.applet.ns.service.impl.business;
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
//import com.spatome.applet.common.vo.BaseVO;
//import com.spatome.applet.ns.entity.Activity;
//import com.spatome.applet.ns.entity.ActivityPrize;
//import com.spatome.applet.ns.service.TranService;
//import com.spatome.applet.ns.service.impl.BaseService;
//import com.spatome.applet.ns.vo.ActivityVO;
//import com.spatome.applet.ns.vo.PrizeVO;
//import com.spatome.applet.util.DUtil;
//import com.spatome.applet.util.SUtil;
//
//import lombok.extern.slf4j.Slf4j;
//
///** 
// * 基本增删改查
// *
// * 活动
// * 查询 带奖品
// */
//@Service
//@Slf4j
//public class Tran10014ServiceImpl extends BaseService implements TranService {
//
//	@Override
//	@Transactional
//	public Object execute(Map<String, String> request, HttpServletRequest req, HttpServletResponse res) {
//		BaseVO<ActivityVO> result = new BaseVO<ActivityVO>();
//		ActivityVO VO = new ActivityVO();
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
//		Activity record = daoFactory.getActivityMapper().selectByPrimaryKey(Long.valueOf(activityId));
//		if (record == null) {
//			result.setCodeMessage("9999", "活动不存在");
//			return result;
//		}
//
//		VO.setActivityId(record.getId());
//		VO.setActivityName(record.getActivityName());
//		VO.setEnterpriseName(record.getEnterpriseName());
//		VO.setAllowDayCount(SUtil.NTS(record.getAllowDayCount()));
//		VO.setCreateTime(DUtil.formatDateApp(record.getCreateTime()));
//		VO.setStatus(record.getStatus());
//
//		ActivityPrize activityPrizeQ = new ActivityPrize();
//		activityPrizeQ.setActivityId(record.getId());
//		List<ActivityPrize> activityPrizeList = daoFactory.getActivityPrizeMapper().selectByBean(activityPrizeQ);
//		for (ActivityPrize activityPrize : activityPrizeList) {
//			PrizeVO prizeVO = new PrizeVO();
//			prizeVO.setPrizeId(activityPrize.getId());
//			prizeVO.setPrizePr(activityPrize.getPrizePr().toPlainString());
//			VO.getPrizeList().add(prizeVO);
//		}
//
//		return result;
//	}
//}
