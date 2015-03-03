package com.machworks.musicasecretary.service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.machworks.musicasecretary.dao.DaoFactory;
import com.machworks.musicasecretary.vo.ArticleHeaderVo;
import com.machworks.musicasecretary.vo.ArticleVo;

@Component
class ArticleServiceImpl implements ArticleService {

	@Qualifier("daofactory")
	@Autowired
	private DaoFactory daoFactory;

	private DaoFactory getDaoFactory() {
		return daoFactory;
	}

	@Override
	public ArticleVo create(ArticleVo newRecord) {
		int newId = getDaoFactory().getArticleDAO().generateNewId();
		ArticleVo vo2Save = new ArticleVo.Builder()
		.id(newId)
		.title(newRecord.getTitle())
		.content(newRecord.getContent())
		.tags(newRecord.getTags())
		.build();
		getDaoFactory().getArticleDAO().create(vo2Save);
		return vo2Save;
	}


	@Override
	public void delete(int articleId) {
		getDaoFactory().getArticleDAO().delete(articleId);
	}


	@Override
	public ArticleVo find(int articleId) {
		return getDaoFactory().getArticleDAO().find(articleId);
	}


	@Override
	public List<ArticleHeaderVo> load() {
		Iterable<ArticleHeaderVo> iterable = () -> getDaoFactory().getArticleDAO().list();
		return StreamSupport.stream(iterable.spliterator(),false)
				.filter(vo -> vo != null)
				.collect(Collectors.toList());
	}


	@Override
	public void update(ArticleVo newRecord) {
		getDaoFactory().getArticleDAO().update(newRecord);
	}
}
