package com.machworks.musicasecretary.controller;


/**
 * common controller of musica_secretary
 * @author machi_000
 *
 */
public abstract class AbsSecretaryController {
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

	
	
}
