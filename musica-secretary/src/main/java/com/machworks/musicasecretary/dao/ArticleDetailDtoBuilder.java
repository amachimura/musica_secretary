package com.machworks.musicasecretary.dao;

import com.worksap.company.dto.annotation.Key;


/**
 * This builder will be deleted.
 * (Required current keyvalueaccess.jar)
 * @author works
 */
public final class ArticleDetailDtoBuilder {
	@Key(isStringKey=false)
	public Integer id = Integer.MAX_VALUE;
	public String content;


	public ArticleDetailDto build() {
		return new ArticleDetailDto(id, content);
	}
}
