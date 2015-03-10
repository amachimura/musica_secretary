package com.machworks.musicasecretary.util;

import java.util.Map;

public class SecretaryUtil {
	public static void appendStringToModel(Map<String, Object> model, String key, String value) {
		if(model.containsKey(key)) {
			model.put(key, (String)model.get(key) + value);
		} else {
			model.put(key, value);
		}
	}
}
