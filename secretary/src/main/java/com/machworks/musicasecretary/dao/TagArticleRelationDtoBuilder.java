package com.machworks.musicasecretary.dao;



/**
 * This builder will be deleted.
 * (Required current keyvalueaccess.jar)
 * @author works
 */
public class TagArticleRelationDtoBuilder {
	public int articleId;
	public int tagId;
	public String key;


	public TagArticleRelationDto build() {
		return new TagArticleRelationDto(articleId, tagId);
	}
}
