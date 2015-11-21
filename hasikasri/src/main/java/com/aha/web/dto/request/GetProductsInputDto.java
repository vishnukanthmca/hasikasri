package com.aha.web.dto.request;

import java.util.List;

public class GetProductsInputDto {

	private List<Long> categoryIds;

	private List<Long> attributeIds;

	private Integer minPrice;

	private Integer maxPrice;

	public List<Long> getCategoryIds() {
		return categoryIds;
	}

	public void setCategoryIds(List<Long> categoryIds) {
		this.categoryIds = categoryIds;
	}

	public List<Long> getAttributeIds() {
		return attributeIds;
	}

	public void setAttributeIds(List<Long> attributeIds) {
		this.attributeIds = attributeIds;
	}

	public Integer getMinPrice() {
		return minPrice;
	}

	public void setMinPrice(Integer minPrice) {
		this.minPrice = minPrice;
	}

	public Integer getMaxPrice() {
		return maxPrice;
	}

	public void setMaxPrice(Integer maxPrice) {
		this.maxPrice = maxPrice;
	}
}
