package com.machworks.musicasecretary.controller;

import java.util.List;
import java.util.stream.Collectors;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.machworks.musicasecretary.entity.ArticleEntity;
import com.machworks.musicasecretary.entity.ArticleHeaderEntity;
import com.machworks.musicasecretary.service.ServiceFactory;
import com.machworks.musicasecretary.vo.ArticleHeaderVo;
import com.machworks.musicasecretary.vo.ArticleVo;


/**
 * Treat all request for articles.
 * 
 * @author works
 */
@Controller
@RequestMapping(value="/webeditor/article")
public class ArticleController {
	@Autowired
	private HttpServletRequest request;

	private ServiceFactory serviceFactory;
	@Autowired
	public ArticleController(ServiceFactory serviceFactory) {
		this.serviceFactory = serviceFactory;
	}
	/**
	 * Add new article.
	 * (But, client send add request when add button is clicked. 'detail' has many empty fields)
	 * 
	 * @param detail This detail does not have articleId
	 * @return This detail has articleId
	 */
	@RequestMapping(value="/add", method = RequestMethod.POST,  produces=MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public ArticleEntity add(@RequestBody ArticleEntity detail) {
		ArticleEntity newEntity = convertVo2Entity(serviceFactory.getArticleService().create(convertEntity2Vo(detail)));
		return newEntity;
	}


	/**
	 * Want to get article title list.
	 * (Paging is not required.
	 *  Be carefully! client send async request.
	 *  If you use H2 embedded mode, H2 will return error.
	 *  Please use H2 server mode)
	 * 
	 * @return
	 */
	@RequestMapping(value="/load", method = RequestMethod.GET,  produces=MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public List<ArticleHeaderEntity> load() {
		List<ArticleHeaderEntity> list = serviceFactory.getArticleService().load().stream()
				.map(vo ->convertHeaderVo2HeaderEntity(vo)).collect(Collectors.toList());
		return list;
	}


	/**
	 * Update article to new one.
	 * Search old one with detail.articleId.
	 * 
	 * @param detail
	 */
	@RequestMapping(value="/put", method = RequestMethod.POST,  produces=MediaType.APPLICATION_JSON_VALUE)
	@ResponseStatus(value = HttpStatus.OK)
	public void put(@RequestBody ArticleEntity detail) {
		serviceFactory.getArticleService().update(convertEntity2Vo(detail));
	}


	/**
	 * Delete article with articleId
	 * 
	 * @param articleId
	 */
	@RequestMapping(value="/delete/{articleId}", method = RequestMethod.POST)
	@ResponseStatus(value = HttpStatus.OK)
	@ResponseBody
	public void delete(@PathVariable("articleId") int articleId) {
		serviceFactory.getArticleService().delete(articleId);
	}


	/**
	 * Get all data with articleId
	 * 
	 * @param articleId
	 * @return
	 */
	@RequestMapping(value="/detail/{articleId}", method = RequestMethod.GET,  produces=MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public ArticleEntity getDetail(@PathVariable("articleId") int articleId) {
		ArticleVo vo = serviceFactory.getArticleService().find(articleId);
		return convertVo2Entity(vo);
	}
	private ArticleVo convertEntity2Vo(ArticleEntity detail){
		return  new ArticleVo.Builder()
		.id(detail.getId())
		.title(detail.getTitle())
		.content(detail.getContent())
		.tags(detail.getTags())
		.build();
	}
	private ArticleEntity convertVo2Entity(ArticleVo vo){
		return new ArticleEntity(vo.getId(),vo.getContent(),vo.getTitle(),vo.getTags());
	}
	private ArticleHeaderEntity convertHeaderVo2HeaderEntity(ArticleHeaderVo vo){
		return new ArticleHeaderEntity(vo.getId(), vo.getTitle(), vo.getTags());
	}
	
}
