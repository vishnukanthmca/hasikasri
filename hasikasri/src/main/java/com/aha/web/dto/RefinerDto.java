package com.aha.web.dto;

import java.util.List;

public class RefinerDto {

	private String name;

	private List<AttributeDto> attributes;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<AttributeDto> getAttributes() {
		return attributes;
	}

	public void setAttributes(List<AttributeDto> attributes) {
		this.attributes = attributes;
	}
}
