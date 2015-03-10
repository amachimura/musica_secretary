package com.machworks.musicasecretary.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.machworks.musicasecretary.util.SecretaryUtil;


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
		serviceProc();
		switchInnerPage(getVmName());
		return new ModelAndView("frame", model);
	}
	
	protected static final String VM_ROOT = "/";
	protected static final String WEBCONTENT_ROOT = "/musica-secretary/";
	
	/**
	 * コントローラが描画する画面のvmファイルの名称を返すように実装してください
	 * @return
	 */
	protected abstract String getVmName();
	/**
	 * コントローラが描画する画面のvmファイルのパスを返します
	 * @return
	 */
	private String getVmPath(String vmName) {
		StringBuilder path = new StringBuilder(VM_ROOT)
		.append(getVmName())
		.append(".vm");
		return path.toString();
	}
	
	/**
	 * 各サービス固有の処理を実装してください。
	 * CSSとかJSとか
	 */
	protected abstract void serviceProc();

	protected void switchInnerPage(String vmName) {
		model.remove("vm_key_contents_template");
		model.put("vm_key_contents_template", getVmPath(vmName));
	}
	
	protected void setLeftSideMenu(String vmName) {
		model.put("vm_key_left_contents", getVmPath(vmName));
	}

	/**
	 * @param cssPath musica-secretaryを除いた相対パスを渡してください。(e.g. "css/menu/menu.css")
	 */
	protected void setCss(String cssPath) {
		SecretaryUtil.appendStringToModel(model, "vm_key_csss", "<link rel=\"stylesheet\" href=\""+WEBCONTENT_ROOT+cssPath+"\" />");
	}
	/**
	 * @param scriptPath musica-secretaryを除いた相対パスを渡してください。(e.g. "js/menu/menu.js")
	 */
	protected void setScript(String scriptPath) {
		SecretaryUtil.appendStringToModel(model, "vm_key_scripts", "<script type=\"text/javascript\" src=\""+WEBCONTENT_ROOT+scriptPath+"\" ></script>");
	}
	
}
