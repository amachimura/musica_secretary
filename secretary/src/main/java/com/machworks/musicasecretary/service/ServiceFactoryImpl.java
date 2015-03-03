package com.machworks.musicasecretary.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ServiceFactoryImpl implements ServiceFactory {

	
	@Autowired
	private TagService tagService;
	@Autowired
	private ArticleService articleService;

	@Override
	public ArticleService getArticleService() {
		return articleService;
	}

	@Override
	public TagService getTagService() {
		return tagService;
	}
}
