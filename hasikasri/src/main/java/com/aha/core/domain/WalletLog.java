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
public class WalletLog {

	@Id
	@GeneratedValue
	private Long id;

	@Column
	private Double amount;

	@OneToOne
	private User user;

	@Column
	@Temporal(TemporalType.TIMESTAMP)
	private Date updatedDate;

	@OneToOne
	private OrderedItem item;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Double getAmount() {
		return amount;
	}

	public void setAmount(Double amount) {
		this.amount = amount;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Date getUpdatedDate() {
		return updatedDate;
	}

	public void setUpdatedDate(Date updatedDate) {
		this.updatedDate = updatedDate;
	}

	public OrderedItem getItem() {
		return item;
	}

	public void setItem(OrderedItem item) {
		this.item = item;
	}
}
