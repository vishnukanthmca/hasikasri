package com.aha.core.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@Entity
public class OrderedItem {

	@Id
	@GeneratedValue
	private Long id;

	@OneToOne
	private Product product;

	@Column
	private Integer quantity;

	@Column
	private Float discount;

	@Column
	private String size;

	@Column
	private Double unitSoldPrice;

	@Column
	private Double totalSoldPrice;

	@Column
	private Double originalPrice;

	@Column
	private Double actualPrice;

	@ManyToOne
	private Order order;

	@Column
	private String orderItemId;

	@Column
	private Integer status;

	@OneToOne(fetch = FetchType.EAGER)
	private ReturnOrder returnOrder;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public Float getDiscount() {
		return discount;
	}

	public void setDiscount(Float discount) {
		this.discount = discount;
	}

	public String getSize() {
		return size;
	}

	public void setSize(String size) {
		this.size = size;
	}

	public Double getUnitSoldPrice() {
		return unitSoldPrice;
	}

	public void setUnitSoldPrice(Double unitSoldPrice) {
		this.unitSoldPrice = unitSoldPrice;
	}

	public Double getTotalSoldPrice() {
		return totalSoldPrice;
	}

	public void setTotalSoldPrice(Double totalSoldPrice) {
		this.totalSoldPrice = totalSoldPrice;
	}

	public Double getOriginalPrice() {
		return originalPrice;
	}

	public void setOriginalPrice(Double originalPrice) {
		this.originalPrice = originalPrice;
	}

	public Double getActualPrice() {
		return actualPrice;
	}

	public void setActualPrice(Double actualPrice) {
		this.actualPrice = actualPrice;
	}

	public Order getOrder() {
		return order;
	}

	public void setOrder(Order order) {
		this.order = order;
	}

	public String getOrderItemId() {
		return orderItemId;
	}

	public void setOrderItemId(String orderItemId) {
		this.orderItemId = orderItemId;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public ReturnOrder getReturnOrder() {
		return returnOrder;
	}

	public void setReturnOrder(ReturnOrder returnOrder) {
		this.returnOrder = returnOrder;
	}

}
