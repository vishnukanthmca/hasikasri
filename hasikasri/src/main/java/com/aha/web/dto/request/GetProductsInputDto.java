package com.aha.web.dto.request;

import java.util.List;

public class GetProductsInputDto {

	private List<Long> categoryIds;

	private List<Long> attributeIds;

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
}
