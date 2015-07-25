package com.aha.web.dto;

import com.aha.core.domain.Category;

public class CategoryDto {

	private CategoryDto categoryDto;

	private Category category;

	private Long id;

	private String name;

	public CategoryDto(Category category) {
		this.category = category;
	}

	public CategoryDto getTransferObject() {
		categoryDto.setId(category.getId());
		categoryDto.setName(category.getName());

		return categoryDto;
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
}
