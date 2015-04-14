package com.machworks.musicasecretary.dao;

import org.springframework.beans.factory.annotation.Autowired;

import com.machworks.musicasecretary.dao.singersearch.SingerDao;

public class DaoFactoryMongoImpl implements DaoFactory {

	private SingerDao singerDao;
	
	@Autowired
	public DaoFactoryMongoImpl(SingerDao singerDao) {
		this.singerDao=singerDao;
	}

	
	@Override
	public ArticleDao getArticleDAO() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public TagDao getTagDAO() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public SingerDao getSingerDao() {
		return this.singerDao;
	}

}
