package com.aha.web.dto;

public class AttributeDto {

	private Long id;

	private String value;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	@Override
	public String toString() {
		return "AttributeDto [id=" + id + ", value=" + value + "]";
	}
}
