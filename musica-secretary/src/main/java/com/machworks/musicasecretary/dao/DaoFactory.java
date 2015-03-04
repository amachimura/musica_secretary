package com.machworks.musicasecretary.dao;

public interface DaoFactory {
	public ArticleDao getArticleDAO();
	public TagDao getTagDAO();
}
