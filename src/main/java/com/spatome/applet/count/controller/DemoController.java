package com.spatome.applet.count.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.spatome.applet.common.vo.BaseVO;

@RestController
@RequestMapping("demo")
public class DemoController extends BaseController {

    @RequestMapping(value = "test", method = RequestMethod.GET)
    public Object test(HttpServletRequest request, HttpServletResponse response) {
    	BaseVO<Object> result = new BaseVO<Object>();

    	LOGGER.info("this is demo/test");

    	result.setBody("boot.demo");

        return result;
    }

    @RequestMapping(value = "test1", method = RequestMethod.POST)
    public Object test1(HttpServletRequest request, HttpServletResponse response) {
    	BaseVO<Object> result = new BaseVO<Object>();

    	LOGGER.info("this is demo/test");

    	result.setBody("boot.demo");

        return result;
    }
}
