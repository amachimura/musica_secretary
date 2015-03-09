package com.machworks.musicasecretary.dao;


public class TagArticleRelationDto {
	public int articleId;
	public int tagId;
	public String key;

	public TagArticleRelationDto(int articleId, int tagId) {
		this.articleId = articleId;
		this.tagId = tagId;
		setKey();
	}


	public int getArticleId() {
		return articleId;
	}


	public int getTagId() {
		return tagId;
	}


	public void setArticleId(int articleId) {
		this.articleId = articleId;
	}


	public void setTagId(int tagId) {
		this.tagId = tagId;
	}
	
	void setKey(){
		this.key = this.tagId + "/" + this.articleId;
	}
}
