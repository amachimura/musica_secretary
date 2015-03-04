package com.machworks.musicasecretary.dao;

import java.sql.ResultSet;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.jdbc.core.JdbcTemplate;


final class ArticleTagRelationDaoJdbcImpl {
	private static final String DELETE_SQL = "DELETE ARTICLE_TAG_RELATION WHERE ARTICLE_ID = ?";
	private static final String INSERT_SQL = "INSERT INTO ARTICLE_TAG_RELATION(ARTICLE_ID, TAG_ID) VALUES (?, ?)";
	private static final String LIST_SQL = "SELECT ARTICLE_ID, TAG_ID FROM ARTICLE_TAG_RELATION ORDER BY ARTICLE_ID";
	private static final String LIST_FOR_ARTICLE_SQL = "SELECT TAG_ID FROM ARTICLE_TAG_RELATION WHERE ARTICLE_ID = ?";

	private JdbcTemplate template;

	public ArticleTagRelationDaoJdbcImpl(JdbcTemplate template) {
		this.template = template;
	}


	void addTags(int articleId, List<Integer> tags){
		tags.forEach(s->{
			template.update(INSERT_SQL,
					ps -> {	ps.setInt(1,articleId);
					ps.setInt(2,s.intValue());
					});
		});
	}


	void deleteTags(int articleId) {
		template.update(DELETE_SQL,
				ps -> {
					ps.setInt(1, articleId);
				});
	}


	List<ArticleTagRelationDto> list() {
		return template.query(LIST_SQL,
				(ResultSet rs, int rowNum) -> {
					return new ArticleTagRelationDto(rs.getInt(1), rs.getInt(2));
				});
	}
	
	Map<Integer, List<Integer>> getAllListForArticle(){
		return list().stream().collect(Collectors.groupingBy(dto -> dto.getArticleId(),
				 Collectors.mapping(dto -> dto.getTagId(),Collectors.toList())));
	}

	List<Integer> listForArticle(int articleId) {
		return template.query(LIST_FOR_ARTICLE_SQL,
				ps -> ps.setInt(1, articleId),
				(ResultSet rs, int rowNum) -> {
					return Integer.valueOf(rs.getInt(1));
				});
	}
}
