package com.spatome.applet.ns.dao;

import java.util.List;

import com.spatome.applet.ns.entity.SysConfig;

public interface SysConfigMapper {
    int deleteByPrimaryKey(String keyId);

    int insert(SysConfig record);

    int insertSelective(SysConfig record);

    SysConfig selectByPrimaryKey(String keyId);

    int updateByPrimaryKeySelective(SysConfig record);

    int updateByPrimaryKey(SysConfig record);

    
    List<SysConfig> selectByBean(SysConfig sysConfigQ);
}