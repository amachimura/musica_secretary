package com.machworks.musicasecretary.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(value="/secretary", produces=MediaType.TEXT_HTML_VALUE)
public class FrameController {
	
	@RequestMapping(value="/", method = RequestMethod.GET)
	public ModelAndView index(HttpServletRequest req) {
		if(!authenticated()) {
			try {
				return new ModelAndView(sendNextPage(req, "/login"));
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("vm_key_contents_template", "/menu.vm");
		return new ModelAndView(getVmName(), model);
	}

	private boolean authenticated() {
		return true;
	}

	private boolean confirmLogin(HttpServletRequest req) {
		return true;		
	}

	private String getVmName() {
		return "frame";
	}

	/**
	 * 画面遷移させます
	 * @param req
	 * @param pageUrl
	 * @return
	 * @throws IOException
	 */
	private String sendNextPage(HttpServletRequest req, String pageUrl) throws IOException {
		return "redirect:" + req.getServletPath() + pageUrl;
	}
}
