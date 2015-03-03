package com.machworks.musicasecretary.dao;

import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.machworks.musicasecretary.vo.ArticleHeaderVo;
import com.machworks.musicasecretary.vo.ArticleVo;
import com.worksap.company.access.KeyValueAccess;
import com.worksap.company.access.cassandra.IndexUtil;


final class ArticleDaoCassandraImpl implements ArticleDao {


	private KeyValueAccess kva;
	private final ArticleDetailDaoCassandraImpl detailDao;
	private final ArticleHeaderDaoCassandraImpl headerDao;
	private final ArticleTagRelationDaoCassandraImpl articleTagRelationDao;
	private final TagArticleRelationDaoCassandraImpl tagArticleRelationDao;
	private static Log log = LogFactory.getLog(ArticleDaoCassandraImpl.class);

	ArticleDaoCassandraImpl(KeyValueAccess kva) {
		this.kva=kva;
		this.detailDao = new ArticleDetailDaoCassandraImpl(this.kva);
		this.headerDao = new ArticleHeaderDaoCassandraImpl(this.kva);
		this.articleTagRelationDao = new ArticleTagRelationDaoCassandraImpl(this.kva);
		this.tagArticleRelationDao = new TagArticleRelationDaoCassandraImpl(this.kva);
	}

	@Override
	public void create(ArticleVo newRecord) {
		headerDao.insert(convertVo2HeaderDto(newRecord));
		detailDao.create(convertVo2DetailDto(newRecord));
		articleTagRelationDao.insert(convertVo2RelationDtos(newRecord));
		tagArticleRelationDao.insert(convertVo2TagRelationDtos(newRecord));
	}


	@Override
	public void delete(int articleId) {
		ArticleVo vo2Delete = find(articleId);
		try {
			headerDao.delete(convertVo2HeaderDto(vo2Delete));
			detailDao.delete(convertVo2DetailDto(vo2Delete));
			articleTagRelationDao.delete(convertVo2RelationDtos(vo2Delete));
			tagArticleRelationDao.delete(convertVo2TagRelationDtos(vo2Delete));
		} catch (RuntimeException e) {
			log.error("couldn't delete article. id:" + articleId + " title:"+vo2Delete.getTitle()+" content:"+vo2Delete.getContent()+" tags:"+vo2Delete.getTags(),e);
			throw e;
		}
	}


	@Override
	public ArticleVo find(int articleId) {
		ArticleHeaderDto headerDto = headerDao.find(articleId);
		ArticleDetailDto detailDto = detailDao.find(articleId);
		List<Integer> tagList = articleTagRelationDao.listForArticle(articleId);
		ArticleVo vo = new ArticleVo.Builder()
		.id(articleId)
		.title(headerDto.getTitle())
		.content(detailDto.getContent())
		.tags(tagList)
		.build();
		return vo;
	}


	@Override
	public int generateNewId() {
		return (int) System.currentTimeMillis();
	}


	@Override
	public Iterator<ArticleHeaderVo> list() {
		ArticleHeaderVo.Builder builder = new ArticleHeaderVo.Builder();
		Map<Integer, List<Integer>> relationList = articleTagRelationDao.getAllListForArticle();
		return headerDao.list().stream()
				.map(dto -> {
					return builder.id(dto.getId())
							.title(dto.getTitle())
							.tags(relationList.get(dto.getId()))
							.build();
				}).collect(Collectors.toList()).iterator();
	}


	@Override
	public void update(ArticleVo newRecord) {
			updateHeader(newRecord);
			updateDetail(newRecord);
			updateRelation(newRecord);
	}

	private void updateRelation(ArticleVo newRecord) {
		List<ArticleTagRelationDto> relation2Delete;
		try {
		relation2Delete = kva.search(String.valueOf(newRecord.getId())+IndexUtil.IDX_SPR, ArticleTagRelationDto.class);
		List<ArticleTagRelationDto> relationDtos = convertVo2RelationDtos(newRecord);
		List<TagArticleRelationDto> tagRelationDtos = convertVo2TagRelationDtos(newRecord);
		articleTagRelationDao.delete(relation2Delete);
		tagArticleRelationDao.delete(relation2Delete.stream()
				.map(relation -> new TagArticleRelationDto(relation.getTagId(), newRecord.getId()))
				.collect(Collectors.toList()));
		articleTagRelationDao.insert(relationDtos);
		tagArticleRelationDao.insert(tagRelationDtos);
		} catch (IOException e) {
			log.error("couldn't search ArticleTagRelation. searchKey:"+newRecord.getId()+IndexUtil.IDX_SPR, e);
			throw new RuntimeException(e);
		}
	}

	private void updateDetail(ArticleVo newRecord) {
		ArticleDetailDto detailDto = convertVo2DetailDto(newRecord);
		detailDao.delete(detailDto);
		detailDao.create(detailDto);
	}

	private void updateHeader(ArticleVo newRecord) {
		ArticleHeaderDto headerDto = convertVo2HeaderDto(newRecord);
		headerDao.delete(headerDto);
		headerDao.insert(headerDto);
	}

	private ArticleHeaderDto convertVo2HeaderDto(ArticleVo vo){
		return new ArticleHeaderDto(vo.getId(), vo.getTitle());
	}

	private ArticleDetailDto convertVo2DetailDto(ArticleVo vo){
		return new ArticleDetailDto(vo.getId(),vo.getContent());
	}

	private List<ArticleTagRelationDto> convertVo2RelationDtos(ArticleVo vo){
		return vo.getTags().stream()
				.map(tag -> new ArticleTagRelationDto(vo.getId(), tag))
				.collect(Collectors.toList());
	}
	private List<TagArticleRelationDto> convertVo2TagRelationDtos(ArticleVo vo){
		return vo.getTags().stream()
				.map(tag -> new TagArticleRelationDto(vo.getId(), tag))
				.collect(Collectors.toList());
	}



}
