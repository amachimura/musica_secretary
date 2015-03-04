package com.machworks.musicasecretary.dao;

import java.sql.ResultSet;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.machworks.musicasecretary.vo.TagVo;

@Component
final class TagDaoJdbcImpl implements TagDao {
	private static final String LIST_SQL = "SELECT ID, NAME FROM ARTICLE_TAG ORDER BY ID";
	
	private JdbcTemplate template;
	
	@Autowired
	public TagDaoJdbcImpl(JdbcTemplate template){
		this.template = template;
	}


	@Cacheable("tags")
	@Override
	@Transactional(readOnly=true)
	public List<TagVo> list() {
		TagVo.Builder builder = new TagVo.Builder();
		return getTemplate().query(LIST_SQL,
				(ResultSet rs, int rowNum) -> {
				return builder.id(rs.getInt(1)).name(rs.getString(2)).build();
				});	
	}


	private JdbcTemplate getTemplate() {
		return template;
	}


	public void setTemplate(JdbcTemplate template) {
		this.template = template;
	}
}
