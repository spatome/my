package com.spatome.yj.manager.controller;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import com.spatome.common.exception.SException;
import com.spatome.common.vo.BaseVO;
import com.spatome.yj.manager.factory.ServiceFactory;

import lombok.extern.slf4j.Slf4j;

@ControllerAdvice
@Slf4j
public class BaseController
{
	@Resource
	protected ServiceFactory serviceFactory;

	@ExceptionHandler(Exception.class)
	@ResponseBody
	public Object handlerException(Exception ex)
	{
		log.error("service未知异常:", ex);
		return new BaseVO<Object>("9999", "内部繁忙，请稍后重试");
	}

	@ExceptionHandler(SException.class)
	@ResponseBody
	public BaseVO<Object> sException(SException ex)
	{
		log.error("service自定义异常:", ex);
		return new BaseVO<Object>(ex.getCode(), ex.getMessage());
	}

}