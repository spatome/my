//package com.spatome.yj.manager.service.impl.business;
//
//import java.math.BigDecimal;
//import java.util.HashMap;
//import java.util.List;
//import java.util.Map;
//
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//
//import org.apache.commons.lang3.StringUtils;
//import org.springframework.stereotype.Service;
//import org.springframework.transaction.annotation.Transactional;
//
//import com.spatome.applet.activity.entity.ActivityPrize;
//import com.spatome.applet.common.exception.SException;
//import com.spatome.applet.common.vo.BaseVO;
//import com.spatome.applet.util.SUtil;
//import com.spatome.yj.manager.service.TranService;
//import com.spatome.yj.manager.service.impl.BaseService;
//
//import lombok.extern.slf4j.Slf4j;
//
///** 
// * 奖品绑定到活动
// */
//@Service
//@Slf4j
//public class Tran10021ServiceImpl extends BaseService implements TranService {
//
//	@Override
//	@Transactional
//	public Object execute(Map<String, String> request, HttpServletRequest req, HttpServletResponse res) {
//		BaseVO<Object> result = new BaseVO<Object>();
//
//		log.debug("获取参数");
//		String activityId = request.get("activityId");
//		String prizeId = request.get("prizeId");
//		String prizePr = request.get("prizePr");	//奖品概率
//		String status = request.get("status"); 		//ON-增加奖品;OFF-移除奖品
//		log.debug("检查参数");
//		Map<String, String> paramMap = new HashMap<String, String>();
//		paramMap.put("activityId", activityId);
//		paramMap.put("prizeId", prizeId);
//		paramMap.put("status", status);
//		super.checkNotEmpty(paramMap);
//
//		log.debug("===========================业务处理=========================");
//		switch (status) {
//		case "ON":
//			this.addPrize(Long.valueOf(activityId), Long.valueOf(prizeId), prizePr);
//			break;
//		case "OFF":
//			this.removePrize(Long.valueOf(activityId), Long.valueOf(prizeId));
//			break;
//		default:
//			result.setCodeMessage("9999", "未定义状态");
//			return result;
//		}
//
//		return result;
//	}
//
//	private void addPrize(Long activityId, Long prizeId, String prizePr){
//		if (StringUtils.isBlank(prizePr) || !SUtil.isAmount(prizePr)) {
//			throw new SException("9999", "奖品概率格式不正确！");
//		}
//		BigDecimal pr = new BigDecimal(prizePr);
//
//		ActivityPrize newActivityPrize = new ActivityPrize();
//		newActivityPrize.setActivityId(activityId);
//		newActivityPrize.setPrizeId(prizeId);
//		newActivityPrize.setPrizePr(pr);
//		daoFactory.getActivityPrizeMapper().insertSelective(newActivityPrize);
//	}
//	private void removePrize(Long activityId, Long prizeId){
//		ActivityPrize activityPrizeQ = new ActivityPrize();
//		activityPrizeQ.setActivityId(activityId);
//		activityPrizeQ.setPrizeId(prizeId);
//		List<ActivityPrize> recordList = daoFactory.getActivityPrizeMapper().selectByBean(activityPrizeQ);
//		for (ActivityPrize activityPrize : recordList) {
//			daoFactory.getActivityPrizeMapper().deleteByPrimaryKey(activityPrize.getId());
//		}
//	}
//}
