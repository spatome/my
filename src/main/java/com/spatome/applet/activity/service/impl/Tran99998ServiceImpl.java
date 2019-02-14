package com.spatome.applet.activity.service.impl;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.spatome.applet.activity.service.TranService;
import com.spatome.applet.common.vo.BaseVO;

import lombok.extern.slf4j.Slf4j;

/** 
 * 测试 
 */
@Service
@Slf4j
public class Tran99998ServiceImpl extends BaseService implements TranService {

	@Override
	@Transactional
	public Object execute(Map<String, String> request, HttpServletRequest req, HttpServletResponse res) {
		BaseVO<Object> result = new BaseVO<Object>();

		log.debug("获取参数");
		//String activityId = request.get("activityId");
		log.debug("检查参数");
		Map<String, String> paramMap = new HashMap<String, String>();
		//paramMap.put("drawCount", drawCount);
		super.checkNotEmpty(paramMap);

		log.debug("===========================业务处理=========================");

		return result;
	}
}