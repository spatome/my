package com.spatome.applet.count.service.impl.business;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.EnumUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.spatome.applet.common.vo.BaseVO;
import com.spatome.applet.count.common.enums.StatusEnum;
import com.spatome.applet.count.entity.ActivityCount;
import com.spatome.applet.count.service.TranService;
import com.spatome.applet.count.service.impl.BaseService;

import lombok.extern.slf4j.Slf4j;

/** 
 * 活动抓阄
 * 基本增删改查
 * 
 * 修改
 */
@Service
@Slf4j
public class Tran10012ServiceImpl extends BaseService implements TranService {

	@Override
	@Transactional
	public Object execute(Map<String, String> request, HttpServletRequest req, HttpServletResponse res) {
		BaseVO<Object> result = new BaseVO<Object>();

		log.debug("获取参数");
		String activityId = request.get("activityId");
		//String ownerNo = request.get("ownerNo");
		String activityName = request.get("activityName");
		String descs = request.get("descs");					//活动详情
		String status = request.get("status");					//状态
		log.debug("检查参数");
		Map<String, String> paramMap = new HashMap<String, String>();
		paramMap.put("activityId", activityId);
		super.checkNotEmpty(paramMap);

		log.debug("===========================业务处理=========================");
		if(status!=null && !EnumUtils.isValidEnum(StatusEnum.class, status)){
			result.setCodeMessage("9999", "状态未定义");
			return result;
		}

		ActivityCount updateActivityCount = new ActivityCount();
		updateActivityCount.setId(Long.valueOf(activityId));
		updateActivityCount.setStatus(status);
		updateActivityCount.setActivityName(activityName);
		updateActivityCount.setDescs(descs);
		daoFactory.getActivityCountMapper().updateByPrimaryKeySelective(updateActivityCount);

		return result;
	}
}
