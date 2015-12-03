package com.aha.web.dto.response;

import com.aha.core.domain.Product;
import com.aha.core.util.Application;

public class ProductDto {

	private Long id;

	private String pid;

	private String name;

	private String shortName;

	private String brand;

	private String image;

	private Double rating;

	private Integer actualPrice;

	private Integer price;

	private Integer discount;

	public ProductDto(Product product) {
		this.createProductDto(product);
	}

	private void createProductDto(Product product) {
		this.id = product.getId();
		this.pid = product.getPid();
		this.name = product.getName();
		this.rating = product.getRating();
		this.price = product.getPrice().intValue();

		if (product.getActualPrice() != null) {
			this.actualPrice = product.getActualPrice().intValue();
		}

		this.createShortName();

		this.image = generateImageLocation(product.getImage());
	}

	private void createShortName() {
		if (this.name != null && this.name.length() > 60) {
			this.shortName = this.name.substring(0, 58) + "...";
		} else {
			this.shortName = this.name;
		}
	}

	private String generateImageLocation(String image) {

		if (image == null) {
			return null;
		}

		return Application.IMAGES_DOMAIN + Application.LISTING_IMAGES_PATH
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

	public String getShortName() {
		return shortName;
	}

	public void setShortName(String shortName) {
		this.shortName = shortName;
	}

}
