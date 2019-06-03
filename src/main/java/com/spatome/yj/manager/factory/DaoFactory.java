package com.spatome.yj.manager.factory;

import com.spatome.yj.manager.dao.AccountLogMapper;
import com.spatome.yj.manager.dao.AccountMapper;
import com.spatome.yj.manager.dao.BarberMapper;
import com.spatome.yj.manager.dao.CustomerMapper;
import com.spatome.yj.manager.dao.OrdersMapper;
import com.spatome.yj.manager.dao.StoreMapper;
import com.spatome.yj.manager.dao.SysConfigMapper;
import com.spatome.yj.manager.dao.SysPermissionMapper;
import com.spatome.yj.manager.dao.SysRoleMapper;
import com.spatome.yj.manager.dao.SysUserMapper;

public interface DaoFactory {

	public SysConfigMapper getSysConfigMapper();
	public SysUserMapper getSysUserMapper();
	public SysRoleMapper getSysRoleMapper();
	public SysPermissionMapper getSysPermissionMapper();

	public AccountMapper getAccountMapper();
	public AccountLogMapper getAccountLogMapper();

	public StoreMapper getStoreMapper();
	public BarberMapper getBarberMapper();
	public CustomerMapper getCustomerMapper();

	public OrdersMapper getOrdersMapper();

}
