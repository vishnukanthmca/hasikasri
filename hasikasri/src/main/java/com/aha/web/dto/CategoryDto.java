package com.aha.web.dto;

import java.util.List;

import com.aha.core.domain.Category;

public class CategoryDto {

	private Long id;

	private String name;

	private List<ProductDto> products; 

	private Category category;

	public CategoryDto(Category category) {
		this.category = category;
		
		this.createCategoryDto();
	}

	public void createCategoryDto() {
		this.setId(category.getId());
		this.setName(category.getName());
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

	public List<ProductDto> getProducts() {
		return products;
	}

	public void setProducts(List<ProductDto> products) {
		this.products = products;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}
}
