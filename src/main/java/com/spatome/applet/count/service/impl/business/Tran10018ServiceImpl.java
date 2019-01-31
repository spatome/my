package com.spatome.applet.count.service.impl.business;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.spatome.applet.common.vo.BaseVO;
import com.spatome.applet.count.common.constants.RedisConstants;
import com.spatome.applet.count.service.TranService;
import com.spatome.applet.count.service.impl.BaseService;

import lombok.extern.slf4j.Slf4j;

/** 
 * 活动
 * 元素
 * 
 * 增加一次
 */
@Service
@Slf4j
public class Tran10018ServiceImpl extends BaseService implements TranService {

	@Override
	@Transactional
	public Object execute(Map<String, String> request, HttpServletRequest req, HttpServletResponse res) {
		BaseVO<Object> result = new BaseVO<Object>();

		log.debug("获取参数");
		String activityId = request.get("activityId");
		String itemId = request.get("itemId");
		log.debug("检查参数");
		Map<String, String> paramMap = new HashMap<String, String>();
		paramMap.put("activityId", activityId);
		paramMap.put("itemId", itemId);
		super.checkNotEmpty(paramMap);

		log.debug("===========================业务处理=========================");
		Long count = super.redisTemplate.boundListOps(RedisConstants.APPLET_COUNT_ITEM+activityId+":"+itemId).rightPush(System.currentTimeMillis());

		result.setBody(count);

		return result;
	}
}
