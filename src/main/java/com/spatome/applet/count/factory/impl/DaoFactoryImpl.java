package com.spatome.applet.count.factory.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import com.spatome.applet.count.dao.ActivityCountItemMapper;
import com.spatome.applet.count.dao.ActivityCountMapper;
import com.spatome.applet.count.dao.ActivityCountReportMapper;
import com.spatome.applet.count.factory.DaoFactory;

@Lazy
@Service
public class DaoFactoryImpl implements DaoFactory
{
	
	@Autowired
	public ActivityCountMapper activityCountMapper;
	@Autowired
	public ActivityCountItemMapper activityCountItemMapper;
	@Autowired
	public ActivityCountReportMapper activityCountReportMapper;

	@Override
	public ActivityCountMapper getActivityCountMapper() {
		return activityCountMapper;
	}
	@Override
	public ActivityCountItemMapper getActivityCountItemMapper() {
		return activityCountItemMapper;
	}
	@Override
	public ActivityCountReportMapper getActivityCountReportMapper() {
		return activityCountReportMapper;
	}

}