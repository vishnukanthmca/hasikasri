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
public class Order {

	@Id
	@GeneratedValue
	private Long id;

	@Column
	private User user;
	
	@Column
	private Date orderedDate;

	@Column
	private Double shippingCharge;

	@OneToOne
	private Delivery delivery;
	
		
}
