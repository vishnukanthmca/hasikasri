package com.aha.web.dto.response;

import java.util.List;

public class FilterDto {

	private Integer minPrice;

	private Integer maxPrice;

	private List<RefinerDto> refiners;

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

	public List<RefinerDto> getRefiners() {
		return refiners;
	}

	public void setRefiners(List<RefinerDto> refiners) {
		this.refiners = refiners;
	}
}
