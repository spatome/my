package com.spatome.applet.activity.factory.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import com.spatome.applet.activity.dao.ActivityMapper;
import com.spatome.applet.activity.dao.ActivityPrizeMapper;
import com.spatome.applet.activity.dao.DrawMapper;
import com.spatome.applet.activity.dao.SysConfigMapper;
import com.spatome.applet.activity.factory.DaoFactory;

@Lazy
@Service
public class DaoFactoryImpl implements DaoFactory
{
	@Autowired
	private ActivityMapper activityMapper;
	@Autowired
	private ActivityPrizeMapper activityPrizeMapper;
	@Autowired
	private DrawMapper drawMapper;
	@Autowired
	private SysConfigMapper sysConfigMapper;

	@Override
	public ActivityMapper getActivityMapper() {
		return activityMapper;
	}

	@Override
	public ActivityPrizeMapper getActivityPrizeMapper() {
		return activityPrizeMapper;
	}

	@Override
	public DrawMapper getDrawMapper() {
		return drawMapper;
	}

	@Override
	public SysConfigMapper getSysConfigMapper() {
		return sysConfigMapper;
	}

}