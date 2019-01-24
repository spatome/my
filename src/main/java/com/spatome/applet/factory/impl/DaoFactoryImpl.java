package com.spatome.applet.factory.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import com.spatome.applet.dao.ActivityZjMapper;
import com.spatome.applet.dao.ZjRecordMapper;
import com.spatome.applet.factory.DaoFactory;

@Lazy
@Service
public class DaoFactoryImpl implements DaoFactory
{
	
	@Autowired
	public ActivityZjMapper activityZjMapper;
	@Autowired
	public ZjRecordMapper zjRecordMapper;
	@Override

	public ActivityZjMapper getActivityZjMapper() {
		return activityZjMapper;
	}
	@Override
	public ZjRecordMapper getZjRecordMapper() {
		return zjRecordMapper;
	}
}