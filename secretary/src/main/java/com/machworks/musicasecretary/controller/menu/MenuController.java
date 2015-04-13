package com.machworks.musicasecretary.controller.menu;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.machworks.musicasecretary.controller.AbsSecretaryController;
import com.machworks.musicasecretary.service.ServiceFactory;

@Controller
@RequestMapping(value="/secretary/menu", produces=MediaType.TEXT_HTML_VALUE)
public class MenuController extends AbsSecretaryController {

	@Override
	protected String getVmName() {
		return "menu";
	}

	@RequestMapping(value="/", method = RequestMethod.GET)
	public ModelAndView index() {
		return new ModelAndView(getVmName());
	}

	@Override
	protected void serviceProc() {
		// TODO Auto-generated method stub
		
	}
}
