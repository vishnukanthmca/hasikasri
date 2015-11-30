package com.aha.web.dto.response;

import com.aha.core.domain.Image;

public class ImageDto {

	private Long imageId;

	private Long productId;

	private String type;

	private String location;

	public ImageDto(Image image, Long productId) {
		super();
		this.imageId = image.getId();
		this.productId = productId;
		this.type = image.getType();
		this.location = image.getLocation();
	}

	public Long getImageId() {
		return imageId;
	}

	public void setImageId(Long imageId) {
		this.imageId = imageId;
	}

	public Long getProductId() {
		return productId;
	}

	public void setProductId(Long productId) {
		this.productId = productId;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	@Override
	public String toString() {
		return "ImageDto [imageId=" + imageId + ", productId=" + productId
				+ ", type=" + type + ", location=" + location + "]";
	}
}
