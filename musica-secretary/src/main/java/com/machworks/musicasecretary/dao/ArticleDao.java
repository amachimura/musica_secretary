package com.machworks.musicasecretary.dao;

import java.util.Iterator;

import com.machworks.musicasecretary.vo.ArticleHeaderVo;
import com.machworks.musicasecretary.vo.ArticleVo;

public interface ArticleDao {
	/**
	 * Create new article(Header, Detail and Tag relations)
	 * 
	 * @param newRecord this record does not have articleId
	 */
	public void create(ArticleVo newRecord);


	/**
	 * Delete article(Header, Detail and Tag relations) with articleId
	 * @param articleId
	 */
	public void delete(int articleId);


	/**
	 * Return all article data(Detail with tags and title(String))
	 * 
	 * @param articleId
	 * @return
	 */
	public ArticleVo find(int articleId);


	/**
	 * Generate new articleId
	 * 
	 * @return newId
	 */
	public int generateNewId();


	/**
	 * Return all header(title) list
	 * 
	 * @return
	 */
	public Iterator<ArticleHeaderVo> list();
	public void update(ArticleVo newRecord);
}
