package com.machworks.musicasecretary.vo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public final class ArticleVo {
	private final int id;
	private final String content;
	private final String title;
	private final List<Integer> tags;


	public static class Builder {
		private int id;
		private String content;
		private String title;
		private List<Integer> tags = new ArrayList<>();


		public Builder id(int id) {
			this.id = id;
			return this;
		}


		public Builder content(String content) {
			this.content = content;
			return this;
		}


		public Builder tags(List<Integer> tags) {
			if (tags == null) {
				this.tags = Collections.emptyList();
			} else {
				this.tags = tags;
			}

			return this;
		}


		public Builder title(String title) {
			this.title = title;
			return this;
		}


		public ArticleVo build() {
			return new ArticleVo(this);
		}
	}


	private ArticleVo() {
		this(new Builder());
	}


	private ArticleVo(Builder builder) {
		this.id = builder.id;
		this.content = builder.content;
		this.title = builder.title;
		this.tags = Collections.unmodifiableList(new ArrayList<>(builder.tags));
	}


	ArticleVo(int id, String content, String title, List<Integer> tags) {
		this.id = id;
		this.content = content;
		this.title = title;
		this.tags = tags;
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
}
