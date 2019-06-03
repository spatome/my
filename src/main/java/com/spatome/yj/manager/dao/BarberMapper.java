package com.spatome.yj.manager.dao;

import com.spatome.yj.manager.entity.Barber;

public interface BarberMapper {
    int deleteByPrimaryKey(Long id);

    int insert(Barber record);

    int insertSelective(Barber record);

    Barber selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Barber record);

    int updateByPrimaryKey(Barber record);
}