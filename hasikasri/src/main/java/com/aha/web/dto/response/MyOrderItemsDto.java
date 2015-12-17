package com.aha.web.dto.response;

import java.util.Date;

import org.joda.time.Days;
import org.joda.time.LocalDate;

import com.aha.core.util.Util;

public class MyOrderItemsDto {

	private String image;

	private String productName;

	private Double price;

	private Integer quantity;

	private String sellerName;

	private Boolean isReturnable;

	private Boolean displayReturnLink;

	private String orderItemId;

	public MyOrderItemsDto(String image, String productName, Double price,
			Integer quantity, String sellerName, Boolean isReturnable,
			Date deliveredDate, String orderItemId) {
		super();
		this.image = image;
		this.productName = productName;
		this.price = price;
		this.quantity = quantity;
		this.sellerName = sellerName;
		this.isReturnable = isReturnable;
		this.orderItemId = orderItemId;

		this.image = Util.generateImageLocation(image);

		this.displayReturnLink = checkReturnDate(deliveredDate);
	}

	private Boolean checkReturnDate(Date deliveredDate) {

		if (deliveredDate != null && this.getIsReturnable() != null
				&& this.getIsReturnable()) {
			LocalDate date1 = new LocalDate(deliveredDate);
			LocalDate currentDate = new LocalDate(deliveredDate);

			int days = Days.daysBetween(currentDate, date1).getDays();

			if (days <= 7) {
				return true;
			}
		}
		return false;
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

	public Boolean getIsReturnable() {
		return isReturnable;
	}

	public void setIsReturnable(Boolean isReturnable) {
		this.isReturnable = isReturnable;
	}

	public Boolean getDisplayReturnLink() {
		return displayReturnLink;
	}

	public void setDisplayReturnLink(Boolean displayReturnLink) {
		this.displayReturnLink = displayReturnLink;
	}

	public String getOrderItemId() {
		return orderItemId;
	}

	public void setOrderItemId(String orderItemId) {
		this.orderItemId = orderItemId;
	}

}
