package com.machworks.musicasecretary.entity;

import java.util.Map;

import com.machworks.musicasecretary.vo.Singer;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@ToString
public class SingerEntity {
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
	
	public SingerEntity(Singer vo){
		this.id=vo.getId();
		this.representiveName=vo.getRepresentiveName();
		this.alphabeticName=vo.getAlphabeticName();
		this.part=vo.getPart();
		this.isProfessional=vo.getIsProfessional();
		this.attributes=vo.getAttributes();
	}
}
