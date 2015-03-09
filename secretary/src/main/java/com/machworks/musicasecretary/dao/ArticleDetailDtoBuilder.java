package com.machworks.musicasecretary.dao;



/**
 * This builder will be deleted.
 * (Required current keyvalueaccess.jar)
 * @author works
 */
public final class ArticleDetailDtoBuilder {
	public Integer id = Integer.MAX_VALUE;
	public String content;


	public ArticleDetailDto build() {
		return new ArticleDetailDto(id, content);
	}
}
