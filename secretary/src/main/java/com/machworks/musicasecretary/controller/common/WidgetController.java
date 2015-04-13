package com.machworks.musicasecretary.controller.common;

import java.util.List;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.machworks.musicasecretary.controller.AbsSecretaryController;
import com.machworks.musicasecretary.entity.ArticleHeaderEntity;
import com.machworks.musicasecretary.service.ServiceFactory;

@Controller
@RequestMapping(value="/secretary/widget")
public class WidgetController extends AbsSecretaryController {

	@Override
	protected String getVmName() {
		// TODO Auto-generated method stub
		return "widget";
	}

	@Override
	protected void serviceProc() {
		// TODO Auto-generated method stub

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
		return null;
	}

}
