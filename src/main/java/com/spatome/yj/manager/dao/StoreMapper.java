package com.spatome.yj.manager.dao;

import com.spatome.yj.manager.entity.Store;

public interface StoreMapper {
    int deleteByPrimaryKey(Long id);

    int insert(Store record);

    int insertSelective(Store record);

    Store selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Store record);

    int updateByPrimaryKey(Store record);
}