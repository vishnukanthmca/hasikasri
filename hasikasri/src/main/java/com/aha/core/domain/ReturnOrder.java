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
public class ReturnOrder {

	@Id
	@GeneratedValue
	private Long id;

	@OneToOne
	private User user;

	@Column
	@Temporal(TemporalType.DATE)
	private Date returnDate;

	@Column
	private Integer status;

	@Column
	private String comments;

	@OneToOne
	private OrderedItem orderedItem;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public Date getReturnDate() {
		return returnDate;
	}

	public void setReturnDate(Date returnDate) {
		this.returnDate = returnDate;
	}

	public String getComments() {
		return comments;
	}

	public void setComments(String comments) {
		this.comments = comments;
	}

	public OrderedItem getOrderedItem() {
		return orderedItem;
	}

	public void setOrderedItem(OrderedItem orderedItem) {
		this.orderedItem = orderedItem;
	}

}
