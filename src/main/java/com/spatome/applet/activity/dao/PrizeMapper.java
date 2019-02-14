package com.spatome.applet.activity.dao;

import java.util.List;

import com.spatome.applet.activity.entity.Prize;
import com.spatome.applet.common.dao.Mapper;

public interface PrizeMapper extends Mapper<Prize> {

	List<Prize> selectByBean(Prize prizeQ);
	
}