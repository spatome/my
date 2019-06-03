package com.spatome.yj.manager.factory.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
import com.spatome.yj.manager.factory.DaoFactory;

@Service
public class DaoFactoryImpl implements DaoFactory {

	@Autowired
	private SysConfigMapper sysConfigMapper;
	@Autowired
	private SysUserMapper sysUserMapper;
	@Autowired
	private SysRoleMapper sysRoleMapper;
	@Autowired
	private SysPermissionMapper sysPermissionMapper;
	@Autowired
	private AccountMapper accountMapper;
	@Autowired
	private AccountLogMapper accountLogMapper;
	@Autowired
	private StoreMapper storeMapper;
	@Autowired
	private BarberMapper barberMapper;
	@Autowired
	private CustomerMapper customerMapper;
	@Autowired
	private OrdersMapper ordersMapper;
	
	@Override
	public SysConfigMapper getSysConfigMapper() {
		return sysConfigMapper;
	}

	@Override
	public SysUserMapper getSysUserMapper() {
		return sysUserMapper;
	}

	@Override
	public SysRoleMapper getSysRoleMapper() {
		return sysRoleMapper;
	}

	@Override
	public SysPermissionMapper getSysPermissionMapper() {
		return sysPermissionMapper;
	}

	@Override
	public AccountMapper getAccountMapper() {
		return accountMapper;
	}

	@Override
	public AccountLogMapper getAccountLogMapper() {
		return accountLogMapper;
	}

	@Override
	public StoreMapper getStoreMapper() {
		return storeMapper;
	}

	@Override
	public BarberMapper getBarberMapper() {
		return barberMapper;
	}

	@Override
	public CustomerMapper getCustomerMapper() {
		return customerMapper;
	}

	@Override
	public OrdersMapper getOrdersMapper() {
		return ordersMapper;
	}

}
