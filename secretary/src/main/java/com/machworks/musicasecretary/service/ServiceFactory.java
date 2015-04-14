package com.machworks.musicasecretary.service;

import com.machworks.musicasecretary.service.singersearch.SingerSearchService;

public interface ServiceFactory {
	public ArticleService getArticleService();
	public TagService getTagService();
	public SingerSearchService getSingerSearchService();
}
