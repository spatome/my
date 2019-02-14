package com.spatome.applet.activity.dao;

import java.util.List;

import com.spatome.applet.activity.entity.ActivityPrize;
import com.spatome.applet.common.dao.Mapper;

public interface ActivityPrizeMapper extends Mapper<ActivityPrize> {

	List<ActivityPrize> selectByBean(ActivityPrize activityPrizeQ);
	
}