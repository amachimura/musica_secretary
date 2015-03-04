package com.machworks.musicasecretary.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(value="/secretary/login", produces=MediaType.TEXT_HTML_VALUE)
public class LoginController extends AbsSecretaryController {
	/**
	 * Return login page.
	 * 
	 * @return login page
	 */
	@RequestMapping(value="/", method = RequestMethod.GET)
	public ModelAndView index() {
		return new ModelAndView(getVmName());
	}

	@RequestMapping(value="/login")
	public ModelAndView login(HttpServletRequest req) {
		if(confirmLogin(req)) {
		return new ModelAndView("frame");
		}
		return new ModelAndView(getVmName());
	}

	private boolean confirmLogin(HttpServletRequest req) {
		return true;		
	}

	@Override
	protected String getVmName() {
		return "login";
	}
}
