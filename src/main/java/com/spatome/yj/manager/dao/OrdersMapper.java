package com.spatome.yj.manager.dao;

import com.spatome.yj.manager.entity.Orders;

public interface OrdersMapper {
    int deleteByPrimaryKey(Long id);

    int insert(Orders record);

    int insertSelective(Orders record);

    Orders selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Orders record);

    int updateByPrimaryKey(Orders record);
}