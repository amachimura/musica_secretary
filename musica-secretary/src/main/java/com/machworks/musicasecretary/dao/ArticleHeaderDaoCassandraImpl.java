package com.machworks.musicasecretary.dao;

import java.io.IOException;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.worksap.company.access.KeyValueAccess;


final class ArticleHeaderDaoCassandraImpl  {
	private KeyValueAccess kva;
	private static Log log = LogFactory.getLog(ArticleHeaderDaoCassandraImpl.class);
	public ArticleHeaderDaoCassandraImpl(KeyValueAccess kva) {
		this.kva = kva;
	}


	ArticleHeaderDto find(Integer articleId) {
		return null;
	}


	List<ArticleHeaderDto> list(){
		try {
			return kva.searchAll(ArticleHeaderDto.class);
		} catch (IOException e) {
			log.error("couldn't listup articleheader.", e);
			throw new RuntimeException(e);
		}
	}


	void insert(ArticleHeaderDto newRecord){		
		try {
			kva.insert(newRecord);
		} catch (IOException e) {
			log.error("couldn't insert articleheader.  id:"+newRecord.getId()+ " title:"+newRecord.getTitle(), e);
			throw new RuntimeException(e);
		}
	}


	void insert(List<ArticleHeaderDto> newRecords){
		try {
			kva.insert(newRecords);
		} catch (IOException e) {
			log.error("couldn't insert articleheaders(list).  newRecords:"+newRecords.toString(), e);
			throw new RuntimeException(e);	
		}
	}



	void delete(ArticleHeaderDto record){
		try {
			kva.delete(record);
		} catch (IOException e) {
			log.error("couldn't delete articleheader.  id:"+record.getId()+ " title:"+record.getTitle(), e);
			throw new RuntimeException(e);		
		}
	}


	void delete(List<ArticleHeaderDto> records) {
		try {
			kva.delete(records);
		} catch (IOException e) {
			log.error("couldn't delete articleheaders(list).");
			records.forEach(dto -> log.error(dto.getId()+dto.getTitle()));		
			log.error(e);
			throw new RuntimeException(e);		
		}
	}
}
