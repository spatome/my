package com.spatome.applet.activity.dao;

import java.util.List;

import com.spatome.applet.activity.entity.Activity;
import com.spatome.applet.common.dao.Mapper;

public interface ActivityMapper extends Mapper<Activity> {
	
	List<Activity> selectByBean(Activity activityQ);
	
}