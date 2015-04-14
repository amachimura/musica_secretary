package com.machworks.musicasecretary.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.machworks.musicasecretary.service.singersearch.SingerSearchService;

@Component
public class ServiceFactoryImpl implements ServiceFactory {

	
	@Autowired
	private TagService tagService;
	@Autowired
	private ArticleService articleService;
	@Autowired
	private SingerSearchService singerSearchService;

	@Override
	public ArticleService getArticleService() {
		return articleService;
	}

	@Override
	public TagService getTagService() {
		return tagService;
	}

	@Override
	public SingerSearchService getSingerSearchService() {
		return singerSearchService;
	}
}
