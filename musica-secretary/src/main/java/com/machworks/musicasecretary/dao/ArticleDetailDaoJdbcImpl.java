package com.machworks.musicasecretary.dao;

import java.sql.ResultSet;

import org.springframework.jdbc.core.JdbcTemplate;


final class ArticleDetailDaoJdbcImpl {
	private static final String DELETE_SQL = "DELETE FROM ARTICLE_DETAIL WHERE ID = ?";
	private static final String INSERT_SQL = "INSERT INTO ARTICLE_DETAIL(ID, CONTENT) VALUES (?, ?)";
	private static final String SELECT_SQL = "SELECT CONTENT FROM ARTICLE_DETAIL WHERE ID = ?";
	private static final String UPDATE_SQL = "UPDATE ARTICLE_DETAIL SET CONTENT = ? WHERE ID = ?";
	
	private JdbcTemplate template;

	public ArticleDetailDaoJdbcImpl(JdbcTemplate template) {
		this.template = template;
	}

	void create(ArticleDetailDto newRecord) {
		template.update(INSERT_SQL,
				ps -> {
					ps.setInt(1, newRecord.getId());
					ps.setString(2, newRecord.getContent());
				});
	}

	void delete(int id) {
		template.update(DELETE_SQL,
				ps -> {
					ps.setInt(1, id);
				});
	}


	ArticleDetailDto find(int articleId) {
		return template.queryForObject(SELECT_SQL,
				(ResultSet rs, int rowNum) -> new ArticleDetailDto(articleId,rs.getString(1))
				,articleId);
	}


	void update(ArticleDetailDto newRecord) {
		template.update(UPDATE_SQL,
				ps -> {
					ps.setString(1, newRecord.getContent());
					ps.setInt(2, newRecord.getId());
				});
	}
}
