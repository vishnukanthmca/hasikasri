package com.aha.core.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Delivery {

	@Id
	@GeneratedValue
	private Long id;

	@OneToOne
	private Address address;
	
	@Column
	private Date shippingDate;
	
	@Column
	private Date expectedDeliveryDate;
	
	

}
