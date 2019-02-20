package com.spatome.applet.ns.factory.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import com.spatome.applet.ns.dao.ArticleMapper;
import com.spatome.applet.ns.dao.SysConfigMapper;
import com.spatome.applet.ns.factory.DaoFactory;

@Lazy
@Service
public class DaoFactoryImpl implements DaoFactory
{
	@Autowired
	private ArticleMapper articleMapper;

	@Autowired
	private SysConfigMapper sysConfigMapper;

	@Override
	public SysConfigMapper getSysConfigMapper() {
		return sysConfigMapper;
	}

	@Override
	public ArticleMapper getArticleMapper() {
		return articleMapper;
	}

}