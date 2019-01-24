package com.spatome.applet.count.factory;

import com.spatome.applet.count.dao.ActivityCountItemMapper;
import com.spatome.applet.count.dao.ActivityCountMapper;
import com.spatome.applet.count.dao.ActivityCountReportMapper;

public interface DaoFactory
{

	public ActivityCountMapper getActivityCountMapper();
	public ActivityCountItemMapper getActivityCountItemMapper();
	public ActivityCountReportMapper getActivityCountReportMapper();

}
