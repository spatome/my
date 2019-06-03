package com.spatome.yj.manager.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.spatome.common.vo.BaseVO;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping(value = "/demo")
@Slf4j
public class DemoController extends BaseController {

	@RequestMapping(value = "test", method = RequestMethod.GET)
	public Object test(HttpServletRequest request, HttpServletResponse response) throws Exception {
		BaseVO<Object> result = new BaseVO<Object>();

		System.out.println("请求test123456:"+request.getRequestURL());
		log.info("请求test123456:"+request.getRequestURL());

		return result;
	}

}
