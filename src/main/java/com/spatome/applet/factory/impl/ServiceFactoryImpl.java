package com.spatome.applet.factory.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import com.spatome.applet.factory.ServiceFactory;
import com.spatome.applet.service.DemoService;

@Lazy
@Service
public class ServiceFactoryImpl implements ServiceFactory {

	@Autowired
	private DemoService demoServiceImpl;

	@Override
	public DemoService getDemoService() {
		return demoServiceImpl;
	}

}
