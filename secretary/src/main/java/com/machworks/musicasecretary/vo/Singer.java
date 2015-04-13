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
	private final String id;
	@Getter
	private final String representiveName;
	@Getter
	private final String alphabeticName;
	@Getter
	private final String part;
	@Getter
	private final Boolean isProfessional;
	@Getter
	private final Map<String, Object> attributes;

}
