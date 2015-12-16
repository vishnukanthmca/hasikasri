package com.aha.web.dto.response;

public class MyOrderItemsDto {

	private String image;

	private String productName;

	private Double price;

	private Integer quantity;

	private String sellerName;

	public MyOrderItemsDto(String image, String productName, Double price,
			Integer quantity, String sellerName) {
		super();
		this.image = image;
		this.productName = productName;
		this.price = price;
		this.quantity = quantity;
		this.sellerName = sellerName;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public String getSellerName() {
		return sellerName;
	}

	public void setSellerName(String sellerName) {
		this.sellerName = sellerName;
	}

}
