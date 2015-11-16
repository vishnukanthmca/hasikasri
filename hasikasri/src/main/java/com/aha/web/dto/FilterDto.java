package com.aha.web.dto;

import java.util.List;

public class FilterDto {

	private List<RefinerDto> refiners;

	private List<ProductDto> products;

	public List<RefinerDto> getRefiners() {
		return refiners;
	}

	public void setRefiners(List<RefinerDto> refiners) {
		this.refiners = refiners;
	}

	public List<ProductDto> getProducts() {
		return products;
	}

	public void setProducts(List<ProductDto> products) {
		this.products = products;
	}
}
