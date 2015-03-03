package com.machworks.musicasecretary.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.machworks.musicasecretary.dao.DaoFactory;
import com.machworks.musicasecretary.vo.TagVo;

@Component
class TagServiceImpl implements TagService {
	
	@Qualifier("daofactory")
	@Autowired
	private DaoFactory daoFactory;
	
	private DaoFactory getDaoFactory() {
		return daoFactory;
	}

	@Override
	public List<TagVo> load() {
		return getDaoFactory().getTagDAO().list();
	}
}
