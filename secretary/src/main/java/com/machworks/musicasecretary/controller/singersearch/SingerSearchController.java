package com.machworks.musicasecretary.controller.singersearch;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.machworks.musicasecretary.controller.AbsSecretaryController;
import com.machworks.musicasecretary.entity.SingerEntity;
import com.machworks.musicasecretary.service.ServiceFactory;
import com.machworks.musicasecretary.vo.Singer;

@Controller
@RequestMapping(value="/secretary/search")
public class SingerSearchController extends AbsSecretaryController {
	

	@Override
	protected String getVmName() {
		// TODO Auto-generated method stub
		return "search";
	}

	@Override
	protected void serviceProc() {
		setScript("js/search/search.js");
	}
	
	@RequestMapping(value="/load", method = RequestMethod.GET,  produces=MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public List<SingerEntity> load() {
		List<SingerEntity> list = serviceFactory.getSingerSearchService().loadAll().stream()
				.map(vo ->new SingerEntity(vo)).collect(Collectors.toList());
		return list;
	}
}
