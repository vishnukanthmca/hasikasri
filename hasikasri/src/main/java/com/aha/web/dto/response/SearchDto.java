package com.aha.web.dto.response;

public class SearchDto {

	private Long id;

	private String name;

	private String type;

	public SearchDto(Long id, String name, String type) {
		super();
		this.id = id;
		this.name = name + " in " + type;
		this.type = type;

	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	@Override
	public String toString() {
		return "SearchDto [id=" + id + ", name=" + name + ", type=" + type
				+ "]";
	}
}
