package com.spatome.applet.ns.factory;

import com.spatome.applet.ns.dao.ArticleMapper;
import com.spatome.applet.ns.dao.SysConfigMapper;

public interface DaoFactory
{

	public ArticleMapper getArticleMapper();
	public SysConfigMapper getSysConfigMapper();

}
