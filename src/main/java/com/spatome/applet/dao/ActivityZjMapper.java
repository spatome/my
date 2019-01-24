package com.spatome.applet.dao;

import java.util.List;

import com.spatome.applet.common.dao.Mapper;
import com.spatome.applet.entity.ActivityZj;

public interface ActivityZjMapper extends Mapper<ActivityZj> {

	List<ActivityZj> selectByBean(ActivityZj activityZjQuery);
	
}