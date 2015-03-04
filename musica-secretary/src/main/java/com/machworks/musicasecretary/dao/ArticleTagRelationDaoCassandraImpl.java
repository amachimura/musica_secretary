package com.machworks.musicasecretary.dao;

import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.worksap.company.access.KeyValueAccess;
import com.worksap.company.access.cassandra.IndexUtil;


final class ArticleTagRelationDaoCassandraImpl {

	private KeyValueAccess kva;
	private static Log log = LogFactory.getLog(ArticleTagRelationDaoCassandraImpl.class);

	public ArticleTagRelationDaoCassandraImpl(KeyValueAccess kva) {
		this.kva = kva;
	}


	void insert(ArticleTagRelationDto articleTagRelationDto) {
		try {
			kva.insert(articleTagRelationDto);
		} catch (IOException e) {
			log.error("couldn't insert articleTagRelation.  articleId:"+articleTagRelationDto.getArticleId()+" tagId:"+articleTagRelationDto.getTagId()+ " key:"+articleTagRelationDto.key, e);
			throw new RuntimeException(e);
		}
	}


	void insert(List<ArticleTagRelationDto> articleTagRelationDtos){
		try {
			kva.insert(articleTagRelationDtos);
		} catch (IOException e) {
			log.error("couldn't insert articleTagRelations(list). list:");
			articleTagRelationDtos.forEach(dto -> log.error("articleId:"+dto.getArticleId()+" tagId:"+
					dto.getTagId()+ " key:"+dto.key));

			log.error(e);
			throw new RuntimeException(e);
		}
	}


	void delete(ArticleTagRelationDto articleTagRelationDto) {
		try {
			kva.delete(articleTagRelationDto);
		} catch (IOException e) {
			log.error("couldn't delete articleTagRelation.  articleId:"+articleTagRelationDto.getArticleId()+" tagId:"+articleTagRelationDto.getTagId()+ " key:"+articleTagRelationDto.key, e);
			throw new RuntimeException(e);
		}
	}


	void delete(List<ArticleTagRelationDto> articleTagRelationDtos){
		try {
			kva.delete(articleTagRelationDtos);
		} catch (IOException e) {
			log.error("couldn't delete articleTagRelations(list). list:");
			articleTagRelationDtos.forEach(dto -> log.error("articleId:"+dto.getArticleId()+" tagId:"+
					dto.getTagId()+ " key:"+dto.key));

			log.error(e);
			throw new RuntimeException(e);
		}
	}


	List<ArticleTagRelationDto> list()  {
		try {
			return kva.searchAll(ArticleTagRelationDto.class);
		} catch (IOException e) {
			log.error("couldn't listup articleTagRelation.", e);
			throw new RuntimeException(e);
		}
	}
	
	Map<Integer, List<Integer>> getAllListForArticle(){
		return list().stream().collect(Collectors.groupingBy(dto -> dto.getArticleId(),
				 Collectors.mapping(dto -> dto.getTagId(),Collectors.toList())));
	}

	List<Integer> listForArticle(int articleId) {
		try {
			return kva.search(String.valueOf(articleId)+IndexUtil.IDX_SPR, ArticleTagRelationDto.class).stream()
					.map(dto -> dto.getTagId()).collect(Collectors.toList());
		} catch (IOException e) {
			log.error("couldn't listup tagListForArticle. articleId:"+articleId, e);
			throw new RuntimeException(e);
		}
	}
}
