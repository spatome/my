package com.spatome.applet.activity.factory;

import com.spatome.applet.activity.dao.ActivityMapper;
import com.spatome.applet.activity.dao.ActivityPrizeMapper;
import com.spatome.applet.activity.dao.DrawMapper;
import com.spatome.applet.activity.dao.SysConfigMapper;

public interface DaoFactory
{

	public ActivityMapper getActivityMapper();
	public ActivityPrizeMapper getActivityPrizeMapper();
	public DrawMapper getDrawMapper();
	public SysConfigMapper getSysConfigMapper();

}
