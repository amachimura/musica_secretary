package com.machworks.musicasecretary.controller.singersearch;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.machworks.musicasecretary.controller.AbsSecretaryController;

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
		// TODO Auto-generated method stub
	}
	
}
