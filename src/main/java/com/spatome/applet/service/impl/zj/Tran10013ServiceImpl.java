package com.spatome.applet.service.impl.zj;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.spatome.applet.entity.ActivityZj;
import com.spatome.applet.service.TranService;
import com.spatome.applet.service.impl.BaseService;
import com.spatome.applet.util.DUtil;
import com.spatome.applet.util.SUtil;
import com.spatome.applet.vo.ActivityZjVO;
import com.spatome.applet.vo.BaseVO;

import lombok.extern.slf4j.Slf4j;

/** 
 * 活动抓阄
 * 基本增删改查
 * 
 * 查询
 */
@Service
@Slf4j
public class Tran10013ServiceImpl extends BaseService implements TranService {

	@Override
	@Transactional
	public Object execute(Map<String, String> request, HttpServletRequest req, HttpServletResponse res) {
		BaseVO<ActivityZjVO> result = new BaseVO<ActivityZjVO>();
		ActivityZjVO VO = new ActivityZjVO();
		result.setBody(VO);

		log.debug("获取参数");
		String activityId = request.get("activityId");
		log.debug("检查参数");
		Map<String, String> paramMap = new HashMap<String, String>();
		paramMap.put("activityId", activityId);
		super.checkNotEmpty(paramMap);

		log.debug("===========================业务处理=========================");
		ActivityZj record = daoFactory.getActivityZjMapper().selectByPrimaryKey(Long.valueOf(activityId));
		if (record == null) {
			result.setCodeMessage("9999", "活动不存在");
			return result;
		}

		VO.setActivityId(record.getId());
		VO.setOwnerNo(record.getOwnerNo());
		VO.setActivityName(record.getActivityName());
		VO.setTotalCount(SUtil.NTS(record.getTotalCount()));
		VO.setDrawCount(SUtil.NTS(record.getDrawCount()));
		VO.setImageUrl("/");
		VO.setHintNo(record.getHintNo());
		VO.setBeginTime(DUtil.formatShortDate(record.getBeginTime()));
		VO.setEndTime(DUtil.formatShortDate(record.getEndTime()));
		VO.setDescs(record.getDescs());
		VO.setStatus(record.getStatus());
		VO.setCreateTime(DUtil.formatDate(record.getCreateTime()));

		return result;
	}
}
