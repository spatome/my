package com.spatome.applet.ns.factory.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import com.spatome.applet.ns.factory.ServiceFactory;
import com.spatome.applet.ns.service.DemoService;

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
