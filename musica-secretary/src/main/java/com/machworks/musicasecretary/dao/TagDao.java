package com.machworks.musicasecretary.dao;

import java.util.List;

import com.machworks.musicasecretary.vo.TagVo;


/**
 * Treat Tag
 * 
 * @author works
 */
public interface TagDao {
	/**
	 * Return all tag list.
	 * It will have id and name.
	 * (Today, client cache it)
	 * 
	 * @return
	 */
	public List<TagVo> list();
}
