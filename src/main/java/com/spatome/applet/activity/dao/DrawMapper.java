package com.spatome.applet.activity.dao;

import java.util.List;

import com.spatome.applet.activity.entity.Draw;
import com.spatome.applet.common.dao.Mapper;

public interface DrawMapper extends Mapper<Draw> {

	List<Draw> selectByBean(Draw drawQ);
	
}