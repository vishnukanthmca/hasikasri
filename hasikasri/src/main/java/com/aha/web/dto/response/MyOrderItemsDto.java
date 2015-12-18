package com.aha.web.dto.response;

import java.util.Date;

import org.joda.time.Days;
import org.joda.time.LocalDate;

import com.aha.core.util.Util;
import com.aha.core.util.Enum.OrderStatus;

public class MyOrderItemsDto {

	private String image;

	private String productName;

	private Double price;

	private Integer quantity;

	private String sellerName;

	private Boolean isReturnable;

	private String returnStatus;

	private String orderItemId;

	private String adminComments;

	private String returnDate;

	public MyOrderItemsDto(String image, String productName, Double price,
			Integer quantity, String sellerName, Boolean isReturnable,
			Date deliveredDate, String orderItemId, Integer status,
			String adminComments, String returnDate) {
		super();
		this.image = image;
		this.productName = productName;
		this.price = price;
		this.quantity = quantity;
		this.sellerName = sellerName;
		this.isReturnable = isReturnable;
		this.orderItemId = orderItemId;
		this.adminComments = adminComments;
		this.returnDate = returnDate;

		this.image = Util.generateImageLocation(image);

		this.returnStatus = checkReturnDate(deliveredDate, status);

	}

	private String checkReturnDate(Date deliveredDate, Integer status) {

		if (deliveredDate != null && this.getIsReturnable() != null
				&& this.getIsReturnable() && status == null) {
			LocalDate date1 = new LocalDate(deliveredDate);
			LocalDate currentDate = new LocalDate(new Date());

			int days = Days.daysBetween(date1, currentDate).getDays();

			if (days <= 7) {
				return "DISPLAY_RETURN_LINK";
			}
		}

		if (status.equals(OrderStatus.RETURN_ORDER_REQUEST_APPROVED.ordinal())) {
			return "RETURNED";
		}

		if (status.equals(OrderStatus.RETURN_ORDER_REQUEST_PLACED.ordinal())) {
			return "RETURN REQUEST PLACED";
		}

		return null;
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

	public String getReturnStatus() {
		return returnStatus;
	}

	public void setReturnStatus(String returnStatus) {
		this.returnStatus = returnStatus;
	}

	public String getOrderItemId() {
		return orderItemId;
	}

	public void setOrderItemId(String orderItemId) {
		this.orderItemId = orderItemId;
	}

	public String getAdminComments() {
		return adminComments;
	}

	public void setAdminComments(String adminComments) {
		this.adminComments = adminComments;
	}

	public String getReturnDate() {
		return returnDate;
	}

	public void setReturnDate(String returnDate) {
		this.returnDate = returnDate;
	}

}
