package com.spatome.applet.dao;

import java.util.List;

import com.spatome.applet.common.dao.Mapper;
import com.spatome.applet.entity.ActivityZj;
import com.spatome.applet.entity.ZjRecord;

public interface ZjRecordMapper extends Mapper<ZjRecord> {

	List<ZjRecord> selectByBean(ActivityZj zjRecordQuery);

}