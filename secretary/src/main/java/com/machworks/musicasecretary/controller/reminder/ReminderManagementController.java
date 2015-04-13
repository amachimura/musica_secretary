package com.machworks.musicasecretary.controller.reminder;

import java.util.Map;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.machworks.musicasecretary.controller.AbsSecretaryController;
import com.machworks.musicasecretary.service.ServiceFactory;

@Controller
@RequestMapping(value="/secretary/reminder/management")
public class ReminderManagementController extends AbsSecretaryController {

	@Override
	protected String getVmName() {
		return "reminder-manager";
	}

	@Override
	protected void serviceProc() {
		setCss("lib/bootcards/css/bootcards-desktop.min.css");
		setScript("lib/bootcards/js/bootcards.min.js");
		setScript("js/reminder/bootcard-manager.js");
	}
	@RequestMapping(value="/fetch/{templateId}", method = RequestMethod.GET,  produces=MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public Map<String, Object> fetch(@PathVariable("templateId") int templateId){
		
		return model;
	}

}
