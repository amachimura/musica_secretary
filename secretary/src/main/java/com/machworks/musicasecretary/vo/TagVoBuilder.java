package com.machworks.musicasecretary.vo;



/**
 * This builder will be deleted.
 * (Required current keyvalueaccess.jar)
 * @author works
 */
public final class TagVoBuilder {
	public Integer id = Integer.MAX_VALUE;
	public String name;
	private TagVo.Builder builder = new TagVo.Builder();


	public TagVo build() {
		builder.id(id);
		builder.name(name);
		return builder.build();
	}
}
