package com.machworks.musicasecretary.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import com.worksap.company.access.KeyValueAccess;


@Qualifier
class DaoFactoryCassandraImpl implements DaoFactory {
	
	private ArticleDao articleDao;
	private TagDao tagDao;
	
	
	@Autowired
	public DaoFactoryCassandraImpl(KeyValueAccess kva) {
		this.articleDao=new ArticleDaoCassandraImpl(kva);
		this.tagDao= new TagDaoCassandraImpl(kva);
	}
	
	
	@Override
	public ArticleDao getArticleDAO() {
		return articleDao;
	}


	@Override
	public TagDao getTagDAO() {
		return tagDao;
	}

}
