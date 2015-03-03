package com.machworks.musicasecretary.dao;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.worksap.company.access.KeyValueAccess;
import com.worksap.company.access.cassandra.IndexUtil;


final class TagArticleRelationDaoCassandraImpl {
	private KeyValueAccess kva;
	private static Log log = LogFactory.getLog(TagArticleRelationDaoCassandraImpl.class);

	public TagArticleRelationDaoCassandraImpl(KeyValueAccess kva) {
		this.kva = kva;
	}


	void insert(TagArticleRelationDto newRecord) {
		try {
			kva.insert(newRecord);
		} catch (IOException e) {
			log.error("couldn't insert TagArticleRelation. tagId:"+newRecord.getTagId()+" articleId:"+newRecord.getArticleId()+ " key:"+newRecord.key, e);
			throw new RuntimeException(e);
		}
	}


	void insert(List<TagArticleRelationDto> newRecords){
		try {
			kva.insert(newRecords);
		} catch (IOException e) {
			log.error("couldn't insert tagArticleRelations(list). list:");
			newRecords.forEach(dto -> log.error(" tagId:"+
					dto.getTagId()+ " articleId:"+dto.getArticleId()+" key:"+dto.key));

			log.error(e);
			throw new RuntimeException(e);
		}
	}


	void delete(TagArticleRelationDto record) {
		try {
			kva.delete(record);
		} catch (IOException e) {
			log.error("couldn't delete TagArticleRelation. tagId:"+record.getTagId()+" articleId:"+record.getArticleId()+ " key:"+record.key, e);
			throw new RuntimeException(e);
		}
	}


	void delete(List<TagArticleRelationDto> records) {
		try {
			kva.delete(records);
		} catch (IOException e) {
			log.error("couldn't delete TagArticleRelations(list). list:");
			records.forEach(dto -> log.error(" tagId:"+
					dto.getTagId()+ " articleId:"+dto.getArticleId()+ " key:"+dto.key));

			log.error(e);
			throw new RuntimeException(e);
		}
	}


	List<TagArticleRelationDto> list(){
		try {
			return kva.searchAll(TagArticleRelationDto.class);
		} catch (IOException e) {
			log.error("couldn't listup TagArticleRelation.", e);
			throw new RuntimeException(e);
			}
	}


	List<Integer> listForTag(int tagId) {
		try {
			return kva.search(String.valueOf(tagId)+IndexUtil.IDX_SPR, TagArticleRelationDto.class).stream()
					.map(dto -> dto.getArticleId()).collect(Collectors.toList());
		} catch (IOException e) {
			log.error("couldn't listup articleListForTag. tagId:"+tagId, e);
			throw new RuntimeException(e);
		}
	}
}
