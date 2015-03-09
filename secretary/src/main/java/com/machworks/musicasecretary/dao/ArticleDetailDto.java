package com.machworks.musicasecretary.dao;



/*
 * You can use DTO in 'default' scope.
 * It means you can use other DAO's default scope function.
 */
final class ArticleDetailDto {
	private int id;
	private String content;


	ArticleDetailDto() {}


	ArticleDetailDto(int id, String content) {
		this.id = id;
		this.content = content;
	}


	public int getId() {
		return id;
	}


	public String getContent() {
		return content;
	}


	public void setId(int id) {
		this.id = id;
	}


	public void setContent(String content) {
		this.content = content;
	}
}
