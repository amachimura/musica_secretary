package com.machworks.musicasecretary.service.singersearch;

import java.util.List;
import java.util.Map;

import com.machworks.musicasecretary.vo.Singer;

public interface SingerSearchService {
	/**
	 * Create new article(Header, Detail and Tag relations)
	 * 
	 * @param newRecord this record does not have articleId
	 */
	public void create(Singer newRecord);


	/**
	 * Delete singer(Header, Detail and Tag relations) with articleId
	 * @param singerId
	 */
	public void delete(int singerId);


	/**
	 * Return all article data(Detail with tags and title(String))
	 * 
	 * @param articleId
	 * @return
	 */
	public Singer find(int singerId);


	/**
	 * Generate new articleId
	 * 
	 * @return newId
	 */
	public int generateNewId();
	
	/**
	 * @return allsingerList
	 */
	public List<Singer> loadAll();

	public List<Singer> findByConditions(Map<String, Object> condition);

	public void update(Singer newRecord);


	List<Singer> findByName(String name);
	List<Singer> findByPart(String part);
}
