package com.aha.web.dto.request;

import java.util.List;

import com.aha.core.util.Util.Sort;

public class GetProductsInputDto {

	private List<Long> categoryIds;

	private List<Long> attributeIds;

	private String sort;

	private Integer minPrice;

	private Integer maxPrice;

	private Sort internalSort;

	public boolean isValidSort() {

		for (Sort s : Sort.values()) {
			if (s.getSort().equals(this.sort)) {
				this.internalSort = s;
				return true;
			}
		}

		return false;
	}

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

	public String getSort() {
		return sort;
	}

	public void setSort(String sort) {
		this.sort = sort;
	}

	public Sort getInternalSort() {
		return internalSort;
	}

	public void setInternalSort(Sort internalSort) {
		this.internalSort = internalSort;
	}
}
