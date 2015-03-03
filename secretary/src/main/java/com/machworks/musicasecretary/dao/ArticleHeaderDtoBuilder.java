package com.machworks.musicasecretary.dao;

import com.worksap.company.dto.annotation.Key;


/**
 * This builder will be deleted.
 * (Required current keyvalueaccess.jar)
 * @author works
 */
public final class ArticleHeaderDtoBuilder {
	@Key(isStringKey=false)
	public Integer id = Integer.MAX_VALUE;
	public String title;


	public ArticleHeaderDto build() {
		return new ArticleHeaderDto(id, title);
	}
}
