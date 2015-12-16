package com.aha.web.dto.response;

import java.util.List;

public class MyOrderDto {

	private String orderId;

	private String receivedPerson;

	private String orderedDate;

	private String orderStatus;

	private AddressDto shippingAddress;

	private AddressDto billingAddress;

	private List<MyOrderItemsDto> items;

	public MyOrderDto(String orderId, String receivedPerson,
			String orderedDate, String orderStatus, AddressDto shippingAddress,
			AddressDto billingAddress) {
		super();
		this.orderId = orderId;
		this.receivedPerson = receivedPerson;
		this.orderedDate = orderedDate;
		this.orderStatus = orderStatus;
		this.shippingAddress = shippingAddress;
		this.billingAddress = billingAddress;
	}

	public String getOrderId() {
		return orderId;
	}

	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}

	public String getReceivedPerson() {
		return receivedPerson;
	}

	public void setReceivedPerson(String receivedPerson) {
		this.receivedPerson = receivedPerson;
	}

	public String getOrderedDate() {
		return orderedDate;
	}

	public void setOrderedDate(String orderedDate) {
		this.orderedDate = orderedDate;
	}

	public String getOrderStatus() {
		return orderStatus;
	}

	public void setOrderStatus(String orderStatus) {
		this.orderStatus = orderStatus;
	}

	public List<MyOrderItemsDto> getItems() {
		return items;
	}

	public void setItems(List<MyOrderItemsDto> items) {
		this.items = items;
	}

	public AddressDto getShippingAddress() {
		return shippingAddress;
	}

	public void setShippingAddress(AddressDto shippingAddress) {
		this.shippingAddress = shippingAddress;
	}

	public AddressDto getBillingAddress() {
		return billingAddress;
	}

	public void setBillingAddress(AddressDto billingAddress) {
		this.billingAddress = billingAddress;
	}
}
