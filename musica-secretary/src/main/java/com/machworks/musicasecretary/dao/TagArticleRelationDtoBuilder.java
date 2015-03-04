package com.machworks.musicasecretary.dao;

import com.worksap.company.dto.annotation.Key;


/**
 * This builder will be deleted.
 * (Required current keyvalueaccess.jar)
 * @author works
 */
public class TagArticleRelationDtoBuilder {
	public int articleId;
	public int tagId;
	@Key
	public String key;


	public TagArticleRelationDto build() {
		return new TagArticleRelationDto(articleId, tagId);
	}
}
