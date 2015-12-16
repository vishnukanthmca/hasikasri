package com.aha.core.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Delivery {

	@Id
	@GeneratedValue
	private Long id;

	@Column
	@Temporal(TemporalType.DATE)
	private Date shippingDate;

	@Column
	@Temporal(TemporalType.DATE)
	private Date expectedDeliveryDate;

	@Column
	@Temporal(TemporalType.DATE)
	private Date orderedDate;

	@Column
	@Temporal(TemporalType.DATE)
	private Date deliveredDate;

	@Column
	private String receivedPerson;

	@OneToOne
	private Address billingAddress;

	@OneToOne
	private Address shippingAddress;

	@Column
	private Boolean isCommonAddress;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getShippingDate() {
		return shippingDate;
	}

	public void setShippingDate(Date shippingDate) {
		this.shippingDate = shippingDate;
	}

	public Date getExpectedDeliveryDate() {
		return expectedDeliveryDate;
	}

	public void setExpectedDeliveryDate(Date expectedDeliveryDate) {
		this.expectedDeliveryDate = expectedDeliveryDate;
	}

	public Date getOrderedDate() {
		return orderedDate;
	}

	public void setOrderedDate(Date orderedDate) {
		this.orderedDate = orderedDate;
	}

	public Date getDeliveredDate() {
		return deliveredDate;
	}

	public void setDeliveredDate(Date deliveredDate) {
		this.deliveredDate = deliveredDate;
	}

	public String getReceivedPerson() {
		return receivedPerson;
	}

	public void setReceivedPerson(String receivedPerson) {
		this.receivedPerson = receivedPerson;
	}

	public Address getBillingAddress() {
		return billingAddress;
	}

	public void setBillingAddress(Address billingAddress) {
		this.billingAddress = billingAddress;
	}

	public Address getShippingAddress() {
		return shippingAddress;
	}

	public void setShippingAddress(Address shippingAddress) {
		this.shippingAddress = shippingAddress;
	}

	public Boolean getIsCommonAddress() {
		return isCommonAddress;
	}

	public void setIsCommonAddress(Boolean isCommonAddress) {
		this.isCommonAddress = isCommonAddress;
	}

}
