package com.machworks.musicasecretary.dao;

import com.machworks.musicasecretary.dao.singersearch.SingerDao;

public interface DaoFactory {
	public ArticleDao getArticleDAO();
	public TagDao getTagDAO();
	public SingerDao getSingerDao();
}
