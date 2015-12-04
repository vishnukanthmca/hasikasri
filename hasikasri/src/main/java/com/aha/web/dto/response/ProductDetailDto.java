package com.aha.web.dto.response;

import java.util.List;

public class ProductDetailDto {

	private String name;

	private List<ImageDto> images;

	private Double rating;

	private Integer actualPrice;

	private Integer price;

	private Integer discount;

	private Integer deliveryCharge;

	private List<DescriptionDto> descriptions;

	public ProductDetailDto(String name, List<ImageDto> images, Double rating,
			Double actualPrice, Double price, Double discount,
			List<DescriptionDto> descriptions) {
		super();
		this.name = name;
		this.images = images;
		this.rating = rating;
		this.price = price.intValue();
		this.descriptions = descriptions;

		if (actualPrice != null) {
			this.actualPrice = actualPrice.intValue();
		}

		if (discount != null) {
			this.discount = discount.intValue();
		}

	}

	public int getImagesSize() {
		if (images == null) {
			return 0;
		}
		return images.size();
	}

	public int getDescriptionsSize() {
		if (this.descriptions == null) {
			return 0;
		}

		return this.descriptions.size();
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

	public Double getRating() {
		return rating;
	}

	public void setRating(Double rating) {
		this.rating = rating;
	}

	public Integer getActualPrice() {
		return actualPrice;
	}

	public void setActualPrice(Integer actualPrice) {
		this.actualPrice = actualPrice;
	}

	public Integer getPrice() {
		return price;
	}

	public void setPrice(Integer price) {
		this.price = price;
	}

	public Integer getDiscount() {
		return discount;
	}

	public void setDiscount(Integer discount) {
		this.discount = discount;
	}

	public Integer getDeliveryCharge() {
		return deliveryCharge;
	}

	public void setDeliveryCharge(Integer deliveryCharge) {
		this.deliveryCharge = deliveryCharge;
	}

	public List<DescriptionDto> getDescriptions() {
		return descriptions;
	}

	public void setDescriptions(List<DescriptionDto> descriptionDtos) {
		this.descriptions = descriptionDtos;
	}

}
