package com.machworks.musicasecretary.vo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public final class ArticleHeaderVo {
	private final int id;
	private final String title;
	private final List<Integer> tags;


	public static class Builder {
		private int id;
		private String title;
		private List<Integer> tags = new ArrayList<>();


		public Builder id(int id) {
			this.id = id;
			return this;
		}


		public Builder title(String title) {
			this.title = title;
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


		public ArticleHeaderVo build() {
			return new ArticleHeaderVo(this);
		}
	}


	private ArticleHeaderVo() {
		this(new Builder());
	}


	private ArticleHeaderVo(Builder builder) {
		this.id = builder.id;
		this.title = builder.title;
		this.tags = Collections.unmodifiableList(new ArrayList<>(builder.tags));
	}


	ArticleHeaderVo(int id, String title, List<Integer> tags) {
		this.id = id;
		this.title = title;
		this.tags = tags;
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
}
