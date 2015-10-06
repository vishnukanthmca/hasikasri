package com.aha.web.dto;

import java.util.List;

import com.aha.core.domain.Category;

public class CategoryDto {

	private Long id;

	private String name;

	private Long parentCategoryId;

	private List<ProductDto> products;

	private List<CategoryDto> children;

	private Integer totalCategoryCount;

	private List<BreadcrumbDto> breadcrumps;

	public CategoryDto(Long id, String name, Category parentCategory) {
		this.id = id;
		this.name = name;

		if (parentCategory != null) {
			this.parentCategoryId = parentCategory.getId();

		}
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

	public Long getParentCategoryId() {
		return parentCategoryId;
	}

	public void setParentCategoryId(Long parentCategoryId) {
		this.parentCategoryId = parentCategoryId;
	}

	public List<CategoryDto> getChildren() {
		return children;
	}

	public void setChildren(List<CategoryDto> children) {
		this.children = children;
	}

	public Integer getTotalCategoryCount() {
		return totalCategoryCount;
	}

	public void setTotalCategoryCount(Integer totalCategoryCount) {
		this.totalCategoryCount = totalCategoryCount;
	}

	public List<BreadcrumbDto> getBreadcrumps() {
		return breadcrumps;
	}

	public void setBreadcrumps(List<BreadcrumbDto> breadcrumps) {
		this.breadcrumps = breadcrumps;
	}
	
	
}
