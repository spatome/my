//package com.spatome.applet.ns.service.impl.business;
//
//import java.math.BigDecimal;
//import java.util.Date;
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
//import com.spatome.applet.common.exception.SException;
//import com.spatome.applet.common.vo.BaseVO;
//import com.spatome.applet.ns.common.enums.StatusEnum;
//import com.spatome.applet.ns.entity.Activity;
//import com.spatome.applet.ns.entity.ActivityPrize;
//import com.spatome.applet.ns.entity.Prize;
//import com.spatome.applet.ns.service.TranService;
//import com.spatome.applet.ns.service.impl.BaseService;
//import com.spatome.applet.ns.vo.PrizeVO;
//import com.spatome.applet.util.convert.JUtil;
//
//import lombok.extern.slf4j.Slf4j;
//
///** 
// * 活动
// * 基本增删改查
// * 
// * 增加(包括奖品)
// */
//@Service
//@Slf4j
//public class Tran10011ServiceImpl extends BaseService implements TranService {
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
//		String prizes = request.get("prizes");					//JSON格式
//		log.debug("检查参数");
//		Map<String, String> paramMap = new HashMap<String, String>();
//		paramMap.put("ownerNo", ownerNo);
//		paramMap.put("activityName", activityName);
//		paramMap.put("allowDayCount", allowDayCount);
//		super.checkNotEmpty(paramMap);
//
//		Date date = new Date();
//
//		log.debug("===========================业务处理=========================");
//		List<PrizeVO> prizeVOList = JUtil.toList(prizes, PrizeVO.class);
//		for (PrizeVO prizeVO : prizeVOList) {
//			if(StringUtils.isBlank(prizeVO.getPrizeName())){
//				throw new SException("9999", "请输入奖品名称");
//			}
//		}
//
//		//创建活动
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
//		//创建奖品
//		
//		for (PrizeVO prizeVO : prizeVOList) {
//			Prize newPrize = new Prize();
//			newPrize.setStatus(StatusEnum.ON.name());
//			newPrize.setCreateTime(date);
//			newPrize.setUpdateTime(date);
//			newPrize.setOwnerNo(ownerNo);
//			newPrize.setPrizeName(prizeVO.prizeName);
//			newPrize.setPrizeCount(Integer.valueOf(prizeVO.getPrizeCount()));
//			newPrize.setPrizeBalance(newPrize.getPrizeCount());
//			newPrize.setPrizeIconName(prizeVO.getPrizeIconName());
//			newPrize.setPrizeImageName(prizeVO.getPrizeImageName());
//			newPrize.setIsEnter(prizeVO.getIsEnter());
//			daoFactory.getPrizeMapper().insertSelective(newPrize);
//
//			ActivityPrize newActivityPrize = new ActivityPrize();
//			newActivityPrize.setActivityId(newActivity.getId());
//			newActivityPrize.setPrizeId(newPrize.getId());
//			newActivityPrize.setPrizePr(new BigDecimal(prizeVO.getPrizePr()));
//			daoFactory.getActivityPrizeMapper().insertSelective(newActivityPrize);
//		}
//
//		return result;
//	}
//}
