package com.machworks.musicasecretary.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;


/**
 * common controller of musica_secretary
 * @author machi_000
 *
 */
public abstract class AbsSecretaryController {
	
	protected Map<String, Object> model;
	
	public AbsSecretaryController(){
		this.model = new HashMap<String, Object>();
	}
	
	@RequestMapping(value="/")
	protected ModelAndView show(){
		switchInnerPage(getVmName());
		return new ModelAndView("frame", model);
	}
	
	protected static final String VM_ROOT = "vm/";
	/**
	 * コントローラが描画する画面のvmファイルの名称を返すように実装してください
	 * @return
	 */
	protected abstract String getVmName();
	/**
	 * コントローラが描画する画面のvmファイルのパスを返します
	 * @return
	 */
	protected String getVmPath() {
		StringBuilder path = new StringBuilder(VM_ROOT)
		.append(getVmName());
		return path.toString();
	}
	
	protected void switchInnerPage(String vmName) {
		model.remove("vm_key_contents_template");
		model.put("vm_key_contents_template", "/"+vmName+".vm");
	}

	
	
}
