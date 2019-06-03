package com.spatome.yj.manager.factory.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spatome.yj.manager.factory.ServiceFactory;
import com.spatome.yj.manager.service.DemoService;

@Service
public class ServiceFactoryImpl implements ServiceFactory {

	@Autowired
	private DemoService demoServiceImpl;
	
	@Override
	public DemoService getDemoService() {
		return demoServiceImpl;
	}

}
