package com.machworks.musicasecretary.controller.reminder;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.machworks.musicasecretary.controller.AbsSecretaryController;
import com.machworks.musicasecretary.service.ServiceFactory;

@Controller
@RequestMapping(value="/secretary/reminder")
public class ReminderSubmitController extends AbsSecretaryController {

	@Override
	protected String getVmName() {
		
		return "reminder";
	}

	@Override
	protected void serviceProc() {
		setCss("lib/bootstrap/datepicker/css/datepicker.css");
		setScript("lib/bootstrap/datepicker/js/bootstrap-datepicker.js");
		setCss("css/reminder/reminder.css");
	}

}
