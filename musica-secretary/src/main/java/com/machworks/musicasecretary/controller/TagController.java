package com.machworks.musicasecretary.controller;

import java.util.List;
import java.util.stream.Collectors;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.machworks.musicasecretary.entity.TagEntity;
import com.machworks.musicasecretary.service.ServiceFactory;


/**
 * Treat all request for Tag
 * 
 * @author works
 */
@Controller
@RequestMapping(value="/webeditor/tag")
public class TagController {
	@Autowired
	private HttpServletRequest request;

	private ServiceFactory serviceFactory;

	@Autowired
	public TagController(ServiceFactory serviceFactory) {
		this.serviceFactory = serviceFactory;
	}
	/**
	 * Want to get tag id and name list.
	 * Because client cache this records, we can send articleDetail with tagId only.
	 * 
	 * @return
	 */
	@RequestMapping(value="/load", method = RequestMethod.GET, produces=MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public List<TagEntity> load() {
		List<TagEntity> list = serviceFactory.getTagService().load().stream()
				.map(vo -> new TagEntity(vo.getId(), vo.getName())).collect(Collectors.toList());
		return list;
	}
}
