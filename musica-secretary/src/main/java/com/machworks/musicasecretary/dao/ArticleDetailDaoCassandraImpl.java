package com.machworks.musicasecretary.dao;

import java.io.IOException;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.worksap.company.access.KeyValueAccess;


final class ArticleDetailDaoCassandraImpl {
	private KeyValueAccess kva;
	private static Log log = LogFactory.getLog(ArticleDetailDaoCassandraImpl.class);
	public ArticleDetailDaoCassandraImpl(KeyValueAccess kva) {
		this.kva = kva;
	}


	void create(ArticleDetailDto articleDetailDto){
		try {
			kva.insert(articleDetailDto);
		} catch (IOException e) {
			log.error("couldn't create articledetail. id:"+articleDetailDto.getId()+ " content:"+articleDetailDto.getContent(), e);
			throw new RuntimeException(e);
		}
	}


	void delete(ArticleDetailDto articleDetailDto){
		try {
			kva.delete(articleDetailDto);
		} catch (IOException e) {
			log.error("couldn't delete articledetail. id:"+articleDetailDto.getId()+ " content:"+articleDetailDto.getContent(), e);
			throw new RuntimeException(e);
		}
	}


	ArticleDetailDto find(Integer articleId) {
		return null;
	}
}
