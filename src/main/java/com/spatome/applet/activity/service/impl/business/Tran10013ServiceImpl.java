package com.spatome.applet.activity.service.impl.business;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.spatome.applet.activity.entity.Activity;
import com.spatome.applet.activity.service.TranService;
import com.spatome.applet.activity.service.impl.BaseService;
import com.spatome.applet.activity.vo.ActivityVO;
import com.spatome.applet.common.vo.BaseVO;
import com.spatome.applet.util.DUtil;
import com.spatome.applet.util.SUtil;

import lombok.extern.slf4j.Slf4j;

/** 
 * 基本增删改查
 *
 * 活动
 * 查询
 */
@Service
@Slf4j
public class Tran10013ServiceImpl extends BaseService implements TranService {

	@Override
	@Transactional
	public Object execute(Map<String, String> request, HttpServletRequest req, HttpServletResponse res) {
		BaseVO<ActivityVO> result = new BaseVO<ActivityVO>();
		ActivityVO VO = new ActivityVO();
		result.setBody(VO);

		log.debug("获取参数");
		String activityId = request.get("activityId");
		log.debug("检查参数");
		Map<String, String> paramMap = new HashMap<String, String>();
		paramMap.put("activityId", activityId);
		super.checkNotEmpty(paramMap);

		log.debug("===========================业务处理=========================");
		Activity record = daoFactory.getActivityMapper().selectByPrimaryKey(Long.valueOf(activityId));
		if (record == null) {
			result.setCodeMessage("9999", "活动不存在");
			return result;
		}

		VO.setActivityId(record.getId());
		VO.setActivityName(record.getActivityName());
		VO.setEnterpriseName(record.getEnterpriseName());
		VO.setAllowDayCount(SUtil.NTS(record.getAllowDayCount()));
		VO.setCreateTime(DUtil.formatDateApp(record.getCreateTime()));
		VO.setStatus(record.getStatus());

		return result;
	}
}
