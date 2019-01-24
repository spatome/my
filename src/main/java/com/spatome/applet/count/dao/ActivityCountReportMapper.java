package com.spatome.applet.count.dao;

import java.util.List;

import com.spatome.applet.common.dao.Mapper;
import com.spatome.applet.count.entity.ActivityCountReport;

public interface ActivityCountReportMapper extends Mapper<ActivityCountReport> {

	List<ActivityCountReport> selectByBean(ActivityCountReport activityCountReportQ);
	
}