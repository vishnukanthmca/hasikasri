package com.aha.web.dto;

import java.util.ArrayList;
import java.util.List;

import com.aha.core.domain.Attribute;
import com.aha.core.domain.Category;
import com.aha.core.domain.Refiner;

public class CategoryDto {

	private Long id;

	private String name;

	private Long parentCategoryId;

	private List<ProductDto> products;

	private List<CategoryDto> children;

	private Integer totalCategoryCount;

	private List<BreadcrumbDto> breadcrumps;

	private List<RefinerDto> refiners;

	private List<Long> childrenIds;

	public CategoryDto(Long id, String name, Category parentCategory) {
		this.id = id;
		this.name = name;

		if (parentCategory != null) {
			this.parentCategoryId = parentCategory.getId();

		}
	}

	public void loadRefinersWithAttribute(List<Refiner> refiners) {

		if (refiners != null) {

			List<RefinerDto> refinerDtos = new ArrayList<>();

			for (Refiner refiner : refiners) {

				RefinerDto refinerDto = new RefinerDto();
				refinerDto.setName(refiner.getName());

				List<Attribute> attributes = refiner.getAttributes();
				List<AttributeDto> attributeDtos = new ArrayList<>();

				if (refiner != null && attributes != null
						&& !attributes.isEmpty()) {

					for (Attribute attribute : attributes) {
						AttributeDto attributeDto = new AttributeDto();
						attributeDto.setId(attribute.getId());
						attributeDto.setName(attribute.getName());

						attributeDtos.add(attributeDto);
					}

					refinerDto.setAttributes(attributeDtos);
				}

				refinerDtos.add(refinerDto);
			}

			this.refiners = refinerDtos;
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

	public List<RefinerDto> getRefiners() {
		return refiners;
	}

	public void setRefiners(List<RefinerDto> refiners) {
		this.refiners = refiners;
	}

	public List<Long> getChildrenIds() {
		return childrenIds;
	}

	public void setChildrenIds(List<Long> childrenIds) {
		this.childrenIds = childrenIds;
	}
}
