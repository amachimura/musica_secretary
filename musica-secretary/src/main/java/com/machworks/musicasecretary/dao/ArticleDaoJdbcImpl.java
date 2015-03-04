package com.machworks.musicasecretary.dao;

import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.machworks.musicasecretary.vo.ArticleHeaderVo;
import com.machworks.musicasecretary.vo.ArticleVo;

@Component
final class ArticleDaoJdbcImpl implements ArticleDao {
	private static final String GET_NEW_ID_SQL = "SELECT ARTICLE_HEADER_ID_SEQ.NEXTVAL";
	
	private JdbcTemplate template;

	private final ArticleDetailDaoJdbcImpl detailDao;
	private final ArticleHeaderDaoJdbcImpl headerDao;
	private final ArticleTagRelationDaoJdbcImpl relationDao;

	@Autowired
	public ArticleDaoJdbcImpl(JdbcTemplate template){
		this.template = template;
		this.detailDao = new ArticleDetailDaoJdbcImpl(this.getTemplate());
		this.headerDao = new ArticleHeaderDaoJdbcImpl(this.getTemplate());
		this.relationDao = new ArticleTagRelationDaoJdbcImpl(this.getTemplate());		
	}
	

	@Override
	@Transactional
	public void create(ArticleVo newRecord) {
		headerDao.create(new ArticleHeaderDto(newRecord.getId(), newRecord.getTitle()));
		detailDao.create(new ArticleDetailDto(newRecord.getId(), newRecord.getContent()));
		relationDao.addTags(newRecord.getId(), newRecord.getTags());
	}


	@Override
	@Transactional
	public void delete(int articleId) {
		headerDao.delete(articleId);
		detailDao.delete(articleId);
		relationDao.deleteTags(articleId);
	}


	@Override
	@Transactional(readOnly=true)
	public ArticleVo find(int articleId) {
		ArticleHeaderDto headerDto = headerDao.find(articleId);
		ArticleDetailDto detailDto = detailDao.find(articleId);
		List<Integer> tagList = relationDao.listForArticle(articleId);
		ArticleVo.Builder builder = new ArticleVo.Builder();
		return builder
				.id(articleId)
				.title(headerDto.getTitle())
				.content(detailDto.getContent())
				.tags(tagList)
				.build();
	}


	@Override
	@Transactional
	public int generateNewId() {
		return getTemplate().queryForObject(GET_NEW_ID_SQL,
				(rs, rowNum) -> {
					return rs.getInt(1);
				});
	}


	@Override
	@Transactional(readOnly=true)
	public Iterator<ArticleHeaderVo> list() {
		ArticleHeaderVo.Builder builder = new ArticleHeaderVo.Builder();
		Map<Integer, List<Integer>> relationList = relationDao.getAllListForArticle();
		return headerDao.list().stream()
				.map(dto -> {
					return builder.id(dto.getId())
							.title(dto.getTitle())
							.tags(relationList.get(dto.getId()))
							.build();
				}).collect(Collectors.toList()).iterator();
	}
	



	@Override
	@Transactional
	public void update(ArticleVo newRecord) {
		headerDao.update(new ArticleHeaderDto(newRecord.getId(),newRecord.getTitle()));
		detailDao.update(new ArticleDetailDto(newRecord.getId(),newRecord.getContent()));
		relationDao.deleteTags(newRecord.getId());
		relationDao.addTags(newRecord.getId(), newRecord.getTags());
	}
	
		
	public ArticleDetailDaoJdbcImpl getDetailDao() {
		return detailDao;
	}

	public ArticleHeaderDaoJdbcImpl getHeaderDao() {
		return headerDao;
	}

	public ArticleTagRelationDaoJdbcImpl getRelationDao() {
		return relationDao;
	}

	private JdbcTemplate getTemplate() {
		return template;
	}

	public void setTemplate(JdbcTemplate template) {
		this.template = template;
	}

}
