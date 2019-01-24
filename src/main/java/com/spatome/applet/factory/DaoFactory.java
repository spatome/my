package com.spatome.applet.factory;

import com.spatome.applet.dao.ActivityZjMapper;
import com.spatome.applet.dao.ZjRecordMapper;

public interface DaoFactory
{

	public ActivityZjMapper getActivityZjMapper();
	public ZjRecordMapper getZjRecordMapper();

}
