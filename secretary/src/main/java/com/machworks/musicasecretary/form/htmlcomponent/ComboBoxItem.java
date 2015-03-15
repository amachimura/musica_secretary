package com.machworks.musicasecretary.form.htmlcomponent;

import java.util.List;

import com.machworks.musicasecretary.form.util.FormUtils.ValueTextPair;

public class ComboBoxItem implements IHtmlComponent {
	private String id;
	private List<ValueTextPair> valuePairs;
	
	private final String DEFAULT_CLASSES = "form-control default-component";
	
	public ComboBoxItem(String id, List<ValueTextPair> items) {
		this.id= id;
		this.valuePairs = items;
	}

	@Override
	public String getEditCenterHtml() {
		StringBuilder sb = new StringBuilder("<select id=\"" + id + "\" class=\""+DEFAULT_CLASSES+"\">");
		valuePairs.stream().map(e -> sb.append("<option value=\""+e.getValue()+"\">"+e.getTextContent()+"</option>"));
		sb.append("</select>");
		return sb.toString(); 
	}

}
