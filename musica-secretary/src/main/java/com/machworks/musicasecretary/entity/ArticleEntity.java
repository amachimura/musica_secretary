package com.machworks.musicasecretary.entity;

import java.util.List;


/**
 * ArticleDetail has all data in article form.
 * So, it has title as string.
 * Because 'Entity' can has setter(in HUE), it should be used little.
 * Only controller need to use it because of JSON serialization(and deserialization).
 * 
 * @author works
 */
public class ArticleEntity {
	private int id;
	private String content;
	private String title;
	private List<Integer> tags;


	public ArticleEntity(int id, String content, String title, List<Integer> tags) {
		super();
		this.id = id;
		this.content = content;
		this.title = title;
		this.tags = tags;
	}
	public ArticleEntity(){
	}


	public int getId() {
		return id;
	}


	public String getContent() {
		return content;
	}


	public String getTitle() {
		return title;
	}


	public List<Integer> getTags() {
		return tags;
	}


	public void setId(int id) {
		this.id = id;
	}


	public void setContent(String content) {
		this.content = content;
	}


	public void setTitle(String title) {
		this.title = title;
	}


	public void setTags(List<Integer> tags) {
		this.tags = tags;
	}
}
