package com.machworks.musicasecretary.form.util;

import com.machworks.musicasecretary.util.Pair;
import com.machworks.musicasecretary.util.SecretaryUtil;

public class FormUtils extends SecretaryUtil {
	
	public class ValueTextPair extends Pair<String, String> {

		public ValueTextPair(String value,
				String textContent) {
			super(value, textContent);
		}
		
		public String getValue(){
			return super.getFirst();
		}
		
		public String getTextContent(){
			return super.getSecond();
		}
	}
}
