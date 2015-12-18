package com.aha.core.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
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
	@Temporal(TemporalType.TIMESTAMP)
	private Date returnDate;

	@Column
	private String comments;

	@OneToOne(fetch = FetchType.EAGER)
	private OrderedItem orderedItem;

	@Column
	@Temporal(TemporalType.TIMESTAMP)
	private Date approvedDate;

	@Column
	@Temporal(TemporalType.TIMESTAMP)
	private Date returnOrderReceivedDate;

	@Column
	private String adminComments;

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

	public Date getApprovedDate() {
		return approvedDate;
	}

	public void setApprovedDate(Date approvedDate) {
		this.approvedDate = approvedDate;
	}

	public String getAdminComments() {
		return adminComments;
	}

	public void setAdminComments(String adminComments) {
		this.adminComments = adminComments;
	}

	public Date getReturnOrderReceivedDate() {
		return returnOrderReceivedDate;
	}

	public void setReturnOrderReceivedDate(Date returnOrderReceivedDate) {
		this.returnOrderReceivedDate = returnOrderReceivedDate;
	}

}
