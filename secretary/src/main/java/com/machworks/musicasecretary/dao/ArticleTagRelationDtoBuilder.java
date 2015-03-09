package com.machworks.musicasecretary.dao;



/**
 * This builder will be deleted.
 * (Required current keyvalueaccess.jar)
 * @author works
 */
public class ArticleTagRelationDtoBuilder {
	public int articleId;
	public int tagId;
	public String key;


	public ArticleTagRelationDto build() {
		return new ArticleTagRelationDto(articleId, tagId);
	}
}
