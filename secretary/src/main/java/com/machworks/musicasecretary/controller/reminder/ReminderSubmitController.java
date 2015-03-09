package com.machworks.musicasecretary.controller.reminder;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.machworks.musicasecretary.controller.AbsSecretaryController;

@Controller
@RequestMapping(value="/secretary/reminder")
public class ReminderSubmitController extends AbsSecretaryController {

	@Override
	protected String getVmName() {
		return "reminder";
	}

	@Override
	protected void serviceProc() {
		model.put("vm_key_csss", "<link rel=\"stylesheet\" href=\"/musica-secretary/css/reminder/reminder.css\" />");
	}

}
