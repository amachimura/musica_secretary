package com.machworks.musicasecretary.service.singersearch;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.machworks.musicasecretary.dao.DaoFactory;
import com.machworks.musicasecretary.vo.Singer;

@Service
public class SingerSearchServiceImpl implements SingerSearchService {

	@Qualifier("daofactory")
	@Autowired
	private DaoFactory daoFactory;

	private DaoFactory getDaoFactory() {
		return daoFactory;
	}

	
	
	@Override
	public void create(Singer newRecord) {
		// TODO Auto-generated method stub

	}

	@Override
	public void delete(int singerId) {
		// TODO Auto-generated method stub

	}

	@Override
	public Singer find(int singerId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int generateNewId() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<Singer> loadAll() {
		return getDaoFactory().getSingerDao().findAll();
	}

	@Override
	public List<Singer> findByConditions(Map<String, Object> condition) {
		return getDaoFactory().getSingerDao().findByConditions(condition);
	}

	@Override
	public void update(Singer newRecord) {
		// TODO Auto-generated method stub

	}

	@Override
	public List<Singer> findByName(String name) {
		// TODO Auto-generated method stub
		return getDaoFactory().getSingerDao().findByName(name);
	}

	@Override
	public List<Singer> findByPart(String part) {
		return getDaoFactory().getSingerDao().findByPart(part);
	}

}
