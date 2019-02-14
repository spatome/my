package com.spatome.applet.activity.service.impl.business;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.spatome.applet.activity.common.enums.StatusEnum;
import com.spatome.applet.activity.entity.Prize;
import com.spatome.applet.activity.service.TranService;
import com.spatome.applet.activity.service.impl.BaseService;
import com.spatome.applet.common.vo.BaseVO;

import lombok.extern.slf4j.Slf4j;

/**
 * 基本增删改查
 *  
 * 奖品
 * 增加
 */
@Service
@Slf4j
public class Tran10020ServiceImpl extends BaseService implements TranService {

	@Override
	@Transactional
	public Object execute(Map<String, String> request, HttpServletRequest req, HttpServletResponse res) {
		BaseVO<Object> result = new BaseVO<Object>();

		log.debug("获取参数");
		String ownerNo = request.get("ownerNo");
		String prizeName = request.get("prizeName");
		String prizeCount = request.get("prizeCount");
		String isEnter = request.get("isEnter");			//是否登记
		String prizeIconName = request.get("prizeIconName");
		String prizeImageName = request.get("prizeImageName");
		log.debug("检查参数");
		Map<String, String> paramMap = new HashMap<String, String>();
		paramMap.put("ownerNo", ownerNo);
		paramMap.put("prizeName", prizeName);
		paramMap.put("prizeCount", prizeCount);
		paramMap.put("isEnter", isEnter);
		super.checkNotEmpty(paramMap);

		Date date = new Date();

		log.debug("===========================业务处理=========================");
		Prize newPrize = new Prize();
		newPrize.setStatus(StatusEnum.ON.name());
		newPrize.setCreateTime(date);
		newPrize.setUpdateTime(date);
		newPrize.setOwnerNo(ownerNo);
		newPrize.setPrizeName(prizeName);
		newPrize.setPrizeCount(Integer.valueOf(prizeCount));
		newPrize.setPrizeBalance(newPrize.getPrizeCount());
		newPrize.setPrizeIconName(prizeIconName);
		newPrize.setPrizeImageName(prizeImageName);
		newPrize.setIsEnter(isEnter);
		daoFactory.getPrizeMapper().insertSelective(newPrize);
		result.setBody(newPrize.getId());

		return result;
	}
}
