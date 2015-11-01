package com.aha.web.dto;

import com.aha.core.domain.Product;
import com.aha.core.util.Application;

public class ProductDto {

	private Long id;

	private String pid;

	private String name;

	private String brand;

	private String image;

	private Double rating;
	
	public ProductDto(Product product) {
		this.createProductDto(product);
	}

	private void createProductDto(Product product) {
		this.id = product.getId();
		this.pid = product.getPid();
		this.name = product.getName();
		this.brand = product.getBrand();
		this.rating = product.getRating();
		this.image = generateImageLocation(product.getImage());
	}

	private String generateImageLocation(String image) {

		if (image == null) {
			return null;
		}

		return Application.IMAGES_DOMAIN + Application.IMAGES_PATH
				+ image.trim();
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

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public Double getRating() {
		return rating;
	}

	public void setRating(Double rating) {
		this.rating = rating;
	}
}
