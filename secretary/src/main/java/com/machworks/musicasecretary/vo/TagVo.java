package com.machworks.musicasecretary.vo;


public final class TagVo {
	private final int id;
	private final String name;


	public static class Builder {
		private int id;
		private String name;


		public Builder id(int id) {
			this.id = id;
			return this;
		}


		public Builder name(String name) {
			this.name = name;
			return this;
		}


		public TagVo build() {
			return new TagVo(this);
		}
	}


	private TagVo() {
		this(new Builder());
	}


	private TagVo(Builder builder) {
		this.id = builder.id;
		this.name = builder.name;
	}


	TagVo(int id, String name) {
		this.id = id;
		this.name = name;
	}


	public int getId() {
		return id;
	}


	public String getName() {
		return name;
	}
}
