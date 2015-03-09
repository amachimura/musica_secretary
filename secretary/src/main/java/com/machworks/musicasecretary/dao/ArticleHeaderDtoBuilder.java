package com.machworks.musicasecretary.dao;



/**
 * This builder will be deleted.
 * (Required current keyvalueaccess.jar)
 * @author works
 */
public final class ArticleHeaderDtoBuilder {
	public Integer id = Integer.MAX_VALUE;
	public String title;


	public ArticleHeaderDto build() {
		return new ArticleHeaderDto(id, title);
	}
}
