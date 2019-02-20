package com.spatome.applet.ns.service.impl;

import java.io.Serializable;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;

import com.spatome.applet.common.exception.SException;
import com.spatome.applet.ns.factory.DaoFactory;
import com.spatome.applet.ns.factory.ServiceFactory;

public abstract class BaseService {

	@Autowired
	protected DaoFactory daoFactory;
	@Autowired
	protected ServiceFactory serviceFactory;

	@Autowired
	protected StringRedisTemplate stringRedisTemplate;
	@Autowired
	protected RedisTemplate<String, Serializable> redisTemplate;

	/**
	 * @Description: 不空检查
	 */
	public void checkNotEmpty(Map<String, String> paramMap)
	{
		for (Map.Entry<String, String> entry : paramMap.entrySet())
		{
			if (entry.getValue()==null || entry.getValue().length()==0)
			{
				throw new SException("9999", entry.getKey() + "不能为空！");
			}
		}
	}
}
