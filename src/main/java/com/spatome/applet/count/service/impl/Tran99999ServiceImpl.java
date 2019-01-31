package com.spatome.applet.count.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.spatome.applet.common.vo.BaseVO;
import com.spatome.applet.count.common.constants.RedisConstants;
import com.spatome.applet.count.service.TranService;

import lombok.extern.slf4j.Slf4j;

/** 
 * 测试 
 */
@Service
@Slf4j
public class Tran99999ServiceImpl extends BaseService implements TranService {

	@Override
	@Transactional
	public Object execute(Map<String, String> request, HttpServletRequest req, HttpServletResponse res) {
		BaseVO<Object> result = new BaseVO<Object>();

		log.debug("获取参数");
		String name = request.get("name");
		log.debug("检查参数");
		Map<String, String> paramMap = new HashMap<String, String>();
		//paramMap.put("drawCount", drawCount);
		super.checkNotEmpty(paramMap);

		log.debug("===========================业务处理=========================");
		System.out.println("==============================");
		List list = super.redisTemplate.boundListOps(RedisConstants.APPLET_COUNT_ITEM+"7:5").range(0, 0);
		for (Object object : list) {
			Long v = (Long)object;
			System.out.println(v);
		}

		return result;
	}
}
