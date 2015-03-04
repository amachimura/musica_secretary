package com.machworks.musicasecretary.entity;

public class TagEntity {
	private int id;
	private String name;


	public TagEntity() {}


	public TagEntity(int id, String name) {
		super();
		this.id = id;
		this.name = name;
	}


	public int getId() {
		return id;
	}


	public String getName() {
		return name;
	}


	public void setId(int id) {
		this.id = id;
	}


	public void setName(String name) {
		this.name = name;
	}
}
