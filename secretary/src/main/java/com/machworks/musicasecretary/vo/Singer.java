package com.machworks.musicasecretary.vo;

import java.util.Map;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;

import org.springframework.data.mongodb.core.mapping.Document;

@Data
@AllArgsConstructor
@Document(collection = "singers")
public class Singer {
	@Getter
	private String id;
	@Getter
	private String representiveName;
	@Getter
	private String alphabeticName;
	@Getter
	private String part;
	@Getter
	private Boolean isProfessional;
	@Getter
	private Map<String, Object> attributes;

}
