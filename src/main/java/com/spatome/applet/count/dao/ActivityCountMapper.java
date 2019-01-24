package com.spatome.applet.count.dao;

import java.util.List;

import com.spatome.applet.common.dao.Mapper;
import com.spatome.applet.count.entity.ActivityCount;

public interface ActivityCountMapper extends Mapper<ActivityCount> {

	List<ActivityCount> selectByBean(ActivityCount activityCountQ);
	
}