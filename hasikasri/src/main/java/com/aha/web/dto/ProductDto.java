package com.aha.web.dto;

import com.aha.core.domain.Product;

public class ProductDto {

	private Long id;
	
	private String pid;

	private Product product;
	
	public ProductDto(Product product) {
		this.product = product;
		
		this.createProductDto();
	}
	
	private void createProductDto() {
		this.id = this.product.getId();
		this.pid = this.product.getPid();
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getPid() {
		return pid;
	}

	public void setPid(String pid) {
		this.pid = pid;
	}
	
	
}

