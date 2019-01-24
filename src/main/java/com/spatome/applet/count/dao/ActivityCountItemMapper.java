package com.spatome.applet.count.dao;

import java.util.List;

import com.spatome.applet.common.dao.Mapper;
import com.spatome.applet.count.entity.ActivityCountItem;

public interface ActivityCountItemMapper extends Mapper<ActivityCountItem> {

	List<ActivityCountItem> selectByBean(ActivityCountItem activityCountItemQ);

}