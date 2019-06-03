//package com.spatome.yj.manager.service.impl.business;
//
//import java.util.ArrayList;
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
//import com.spatome.applet.activity.entity.ActivityPrize;
//import com.spatome.applet.activity.entity.Prize;
//import com.spatome.applet.activity.vo.PrizeVO;
//import com.spatome.applet.common.vo.BaseVO;
//import com.spatome.applet.util.SUtil;
//import com.spatome.yj.manager.service.TranService;
//import com.spatome.yj.manager.service.impl.BaseService;
//
//import lombok.extern.slf4j.Slf4j;
//
///** 
// * 活动的
// *
// * 奖品
// */
//@Service
//@Slf4j
//public class Tran10016ServiceImpl extends BaseService implements TranService {
//
//	@Override
//	@Transactional
//	public Object execute(Map<String, String> request, HttpServletRequest req, HttpServletResponse res) {
//		BaseVO<List<PrizeVO>> result = new BaseVO<List<PrizeVO>>();
//		List<PrizeVO> prizeVOList = new ArrayList<PrizeVO>();
//		result.setBody(prizeVOList);
//
//		log.debug("获取参数");
//		String activityId = request.get("activityId");
//		log.debug("检查参数");
//		Map<String, String> paramMap = new HashMap<String, String>();
//		paramMap.put("activityId", activityId);
//		super.checkNotEmpty(paramMap);
//
//		log.debug("===========================业务处理=========================");
//		ActivityPrize activityPrizeQ = new ActivityPrize();
//		activityPrizeQ.setActivityId(Long.valueOf(activityId));
//		List<ActivityPrize> activityPrizeList = daoFactory.getActivityPrizeMapper().selectByBean(activityPrizeQ);
//		for (ActivityPrize activityPrize : activityPrizeList) {
//			Prize prize = daoFactory.getPrizeMapper().selectByPrimaryKey(activityPrize.getPrizeId());
//			PrizeVO prizeVO = new PrizeVO();
//			prizeVO.setPrizeId(prize.getId());
//			prizeVO.setPrizePr(activityPrize.getPrizePr().toPlainString());
//			prizeVO.setPrizeName(prize.getPrizeName());
//			prizeVO.setPrizeCount(SUtil.NTS(prize.getPrizeCount()));
//			prizeVO.setIsEnter(prize.getIsEnter());
//			prizeVOList.add(prizeVO);
//		}
//
//		return result;
//	}
//}
