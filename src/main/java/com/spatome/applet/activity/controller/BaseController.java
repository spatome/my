package com.spatome.applet.activity.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import com.spatome.applet.activity.common.config.MyConfig;
import com.spatome.applet.activity.factory.DaoFactory;
import com.spatome.applet.activity.factory.ServiceFactory;
import com.spatome.applet.common.exception.SException;
import com.spatome.applet.common.vo.BaseVO;

@ControllerAdvice
public class BaseController {
	protected final static Logger LOGGER = LoggerFactory.getLogger(BaseController.class);

	@Autowired
	protected DaoFactory daoFactory;
	@Autowired
	protected ServiceFactory serviceFactory;
	@Autowired
	protected MyConfig myConfig;

	@ExceptionHandler(Exception.class)
	@ResponseBody
	public BaseVO<Object> handlerException(Exception ex){
		LOGGER.error("service未知异常:", ex);
		return new BaseVO<Object>("9999", "内部异常，清稍后重试");
	}

	@ExceptionHandler(SException.class)
	@ResponseBody
	public BaseVO<Object> sException(SException ex){
		LOGGER.error("service自定义异常:", ex);
		return new BaseVO<Object>(ex.getCode(), ex.getMessage());
	}
}
