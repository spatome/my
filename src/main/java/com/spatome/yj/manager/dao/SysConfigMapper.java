package com.spatome.yj.manager.dao;

import com.spatome.yj.manager.entity.SysConfig;

public interface SysConfigMapper {
    int deleteByPrimaryKey(String keyId);

    int insert(SysConfig record);

    int insertSelective(SysConfig record);

    SysConfig selectByPrimaryKey(String keyId);

    int updateByPrimaryKeySelective(SysConfig record);

    int updateByPrimaryKey(SysConfig record);
}