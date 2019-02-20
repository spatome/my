package com.spatome.applet.ns.dao;

import java.util.List;

import com.spatome.applet.common.dao.Mapper;
import com.spatome.applet.ns.entity.Article;

public interface ArticleMapper extends Mapper<Article> {

	List<Article> selectByBean(Article articleQ);

}