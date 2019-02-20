package com.spatome.applet.activity.service.impl.business;

import java.math.BigDecimal;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.spatome.applet.activity.common.enums.StatusEnum;
import com.spatome.applet.activity.entity.Activity;
import com.spatome.applet.activity.entity.ActivityPrize;
import com.spatome.applet.activity.entity.Prize;
import com.spatome.applet.activity.service.TranService;
import com.spatome.applet.activity.service.impl.BaseService;
import com.spatome.applet.activity.vo.PrizeVO;
import com.spatome.applet.common.exception.SException;
import com.spatome.applet.common.vo.BaseVO;
import com.spatome.applet.util.convert.JUtil;

import lombok.extern.slf4j.Slf4j;

/** 
 * 增删改查
 * 
 * 奖品s
 * 修改
 */
@Service
@Slf4j
public class Tran10022ServiceImpl extends BaseService implements TranService {

	@Override
	@Transactional
	public Object execute(Map<String, String> request, HttpServletRequest req, HttpServletResponse res) {
		BaseVO<Object> result = new BaseVO<Object>();

		log.debug("获取参数");
		String activityId = request.get("activityId");
		String prizes = request.get("prizes");					//JSON格式
		log.debug("检查参数");
		Map<String, String> paramMap = new HashMap<String, String>();
		paramMap.put("activityId", activityId);
		paramMap.put("prizes", prizes);
		super.checkNotEmpty(paramMap);

		Date date = new Date();
		
		log.debug("===========================业务处理=========================");
		Activity activity = daoFactory.getActivityMapper().selectByPrimaryKey(Long.valueOf(activityId));
		if(activity==null){
			result.setCodeMessage("9999", "活动不存在");
			return result;
		}

		List<PrizeVO> prizeVOList = JUtil.toList(prizes, PrizeVO.class);
		if(prizeVOList==null || prizeVOList.size()==0){
			result.setCodeMessage("9999", "没有奖品要修改");
			return result;
		}
		BigDecimal prizePrs = BigDecimal.ZERO;
		for (PrizeVO prizeVO : prizeVOList) {
			if(StringUtils.isBlank(prizeVO.getPrizeName())){
				throw new SException("9999", "请输入奖品名称");
			}
			prizePrs = new BigDecimal(prizeVO.getPrizePr()).add(prizePrs);
		}
		if(prizePrs.compareTo(new BigDecimal("100"))>0){
			result.setCodeMessage("9999", "奖品总概率不能大于100");
			return result;
		}

		for (PrizeVO prizeVO : prizeVOList) {
			Long actId = Long.valueOf(activityId);
			Long prizeId = prizeVO.getPrizeId();

			if(prizeId==null){
				//新增
				Prize newPrize = new Prize();
				newPrize.setStatus(StatusEnum.ON.name());
				newPrize.setCreateTime(date);
				newPrize.setUpdateTime(date);
				newPrize.setOwnerNo(activity.getOwnerNo());
				newPrize.setPrizeName(prizeVO.getPrizeName());
				newPrize.setPrizeCount(Integer.valueOf(prizeVO.getPrizeCount()));
				newPrize.setPrizeBalance(newPrize.getPrizeCount());
				newPrize.setPrizeIconName(prizeVO.getPrizeIconName());
				newPrize.setPrizeImageName(prizeVO.getPrizeImageName());
				newPrize.setIsEnter(prizeVO.getIsEnter());
				daoFactory.getPrizeMapper().insertSelective(newPrize);

				ActivityPrize newActivityPrize = new ActivityPrize();
				newActivityPrize.setActivityId(actId);
				newActivityPrize.setPrizeId(newPrize.getId());
				newActivityPrize.setPrizePr(new BigDecimal(prizeVO.getPrizePr()));
				daoFactory.getActivityPrizeMapper().insertSelective(newActivityPrize);
			}else{
				//修改
				ActivityPrize activityPrizeQ = new ActivityPrize();
				activityPrizeQ.setActivityId(actId);
				activityPrizeQ.setPrizeId(prizeId);
				List<ActivityPrize> activityPrizeList = daoFactory.getActivityPrizeMapper().selectByBean(activityPrizeQ);
				for (ActivityPrize activityPrize : activityPrizeList) {
					ActivityPrize updateActivityPrize = new ActivityPrize();
					updateActivityPrize.setId(activityPrize.getId());
					updateActivityPrize.setPrizePr(new BigDecimal(prizeVO.getPrizePr()));
					daoFactory.getActivityPrizeMapper().updateByPrimaryKeySelective(updateActivityPrize);
				}

				Prize prize = daoFactory.getPrizeMapper().selectByPrimaryKey(prizeId);
				Prize updatePrize = new Prize();
				updatePrize.setId(prize.getId());
				updatePrize.setPrizeName(prizeVO.getPrizeName());
				updatePrize.setPrizeCount(Integer.valueOf(prizeVO.getPrizeCount()));
				updatePrize.setIsEnter(prizeVO.getIsEnter());
				updatePrize.setPrizeIconName(prizeVO.getPrizeIconName());
				updatePrize.setPrizeImageName(prizeVO.getPrizeImageName());
				daoFactory.getPrizeMapper().updateByPrimaryKeySelective(updatePrize);				
			}
		}
		
		return result;
	}
}
