package com.machworks.musicasecretary.dao;

import java.io.IOException;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.cache.annotation.Cacheable;

import com.machworks.musicasecretary.vo.TagVo;
import com.worksap.company.access.KeyValueAccess;


final class TagDaoCassandraImpl implements TagDao {
	private KeyValueAccess kva;
	private static Log log = LogFactory.getLog(TagDaoCassandraImpl.class);
	
	
	TagDaoCassandraImpl(KeyValueAccess kva) {
		this.kva = kva;
	}
	
	public TagDaoCassandraImpl() {
	}
	
	@Cacheable("tags")
	@Override
	public List<TagVo> list() {
		try {
			return kva.searchAll(TagVo.class);
		} catch (IOException e) {
			log.error("couldn't get tag list.",e);
			throw new RuntimeException(e);
		}
	}
}
