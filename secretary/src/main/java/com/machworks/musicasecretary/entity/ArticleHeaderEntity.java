package com.machworks.musicasecretary.entity;

import java.util.List;

public class ArticleHeaderEntity {
	private int id;
	private String title;
	private List<Integer> tags;


	public ArticleHeaderEntity(int id, String title, List<Integer> tags) {
		super();
		this.id = id;
		this.title = title;
		this.tags = tags;
	}
	
	
	public ArticleHeaderEntity() {
	}


	public int getId() {
		return id;
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


	public void setTitle(String title) {
		this.title = title;
	}


	public void setTag(List<Integer> tags) {
		this.tags = tags;
	}
}
