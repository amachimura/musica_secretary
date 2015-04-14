package com.machworks.musicasecretary.dao.singersearch;

import java.util.List;
import java.util.Map;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.BasicQuery;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Component;

import com.machworks.musicasecretary.util.config.MongoConfig;
import com.machworks.musicasecretary.vo.Singer;

@Component
public class SingerDaoMongoImpl implements SingerDao {
	
	private ApplicationContext ctx = new AnnotationConfigApplicationContext(MongoConfig.class);
    private MongoOperations mongoOperation = (MongoOperations)ctx.getBean("mongoTemplate");

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
	public List<Singer> findAll() {
	    List<Singer> result = mongoOperation.findAll(Singer.class);	
		return result;
	}

	@Override
	public List<Singer> findByName(String name) {
		Query regexQuery = new Query();
		regexQuery.addCriteria(Criteria.where("representiveName").regex("*"+name+"*"));
		
		List<Singer> result = mongoOperation.find(regexQuery, Singer.class);
		return result;
	}

	@Override
	public void update(Singer newRecord) {
		// TODO Auto-generated method stub

	}

	@Override
	public List<Singer> findByConditions(Map<String, Object> condition) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Singer> findByPart(String part) {
		List<Singer> result = mongoOperation.find(new BasicQuery("{part: '"+part+"'}"), Singer.class);
		return result;
	}

}
