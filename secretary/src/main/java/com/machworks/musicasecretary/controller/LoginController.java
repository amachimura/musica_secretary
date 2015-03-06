package com.machworks.musicasecretary.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(value="/secretary/login", produces=MediaType.TEXT_HTML_VALUE)
public class LoginController {
	/**
	 * Return login page.
	 * 
	 * @return login page
	 */
	@RequestMapping(value="/", method = RequestMethod.GET)
	public ModelAndView index() {
		return new ModelAndView(getVmName());
	}

	@RequestMapping(value="/", method = RequestMethod.POST)
	public ModelAndView login(HttpServletRequest req) {
		if(confirmLogin(req)) {
			try {
				return new ModelAndView(sendNextPage(req, "secretary/"));
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return new ModelAndView(getVmName());
	}

	private boolean confirmLogin(HttpServletRequest req) {
		return true;		
	}

	private String getVmName() {
		return "login";
	}

	/**
	 * 画面遷移させます
	 * @param req
	 * @param pageUrl
	 * @return
	 * @throws IOException
	 */
	private String sendNextPage(HttpServletRequest req, String pageUrl) throws IOException {
		return "redirect:" + "/" + pageUrl;
	}

}
