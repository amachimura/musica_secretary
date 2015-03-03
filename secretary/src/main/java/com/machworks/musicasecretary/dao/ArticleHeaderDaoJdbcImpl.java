package com.machworks.musicasecretary.dao;

import java.sql.ResultSet;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;



final class ArticleHeaderDaoJdbcImpl {
	private static final String DELETE_SQL = "DELETE FROM ARTICLE_HEADER WHERE ID = ?";
	private static final String INSERT_SQL = "INSERT INTO ARTICLE_HEADER(ID, TITLE) VALUES (?, ?)";
	private static final String LIST_SQL = "SELECT ID, TITLE FROM ARTICLE_HEADER ORDER BY ID";
	private static final String SELECT_SQL = "SELECT TITLE FROM ARTICLE_HEADER WHERE ID = ?";
	private static final String UPDATE_SQL = "UPDATE ARTICLE_HEADER SET TITLE = ? WHERE ID = ?";

	private JdbcTemplate template;

	public ArticleHeaderDaoJdbcImpl(JdbcTemplate template) {
		this.template = template;
	}

	void create(ArticleHeaderDto newRecord) {
		template.update(INSERT_SQL,
				ps -> {
					ps.setInt(1, newRecord.getId());
					ps.setString(2, newRecord.getTitle());
				});
	}


	void delete(int id) {
		template.update(DELETE_SQL,
				ps -> {
					ps.setInt(1, id);
				});
	}


	ArticleHeaderDto find(int articleId) {
		return template.queryForObject(SELECT_SQL,
				(ResultSet rs, int rowNum) -> new ArticleHeaderDto(articleId, rs.getString(1))
				, articleId);
	}


	List<ArticleHeaderDto> list() {
		return template.query(LIST_SQL,
				(ResultSet rs, int rowNum) -> new ArticleHeaderDto(rs.getInt(1), rs.getString(2))	
				);
	}


	void update(ArticleHeaderDto newRecord) {
		template.update(UPDATE_SQL,
				ps -> {
					ps.setString(1, newRecord.getTitle());
					ps.setInt(2, newRecord.getId());
				});
	}
}
