package com.aha.web.dto.response;

import java.util.List;

public class ProductDetailDto {

	private String name;

	private List<ImageDto> images;

	public ProductDetailDto(String name, List<ImageDto> images) {
		super();
		this.name = name;
		this.images = images;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<ImageDto> getImages() {
		return images;
	}

	public void setImages(List<ImageDto> images) {
		this.images = images;
	}
}
