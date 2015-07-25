package com.aha.core.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Address {

	enum State {
		KARNATAKA
	}

	@Id
	@GeneratedValue
	private Long id;

	@OneToOne(targetEntity = City.class)
	private City city;

	@Column
	private String state;

	@Column
	private String address;

	@Column(length = 7)
	private Integer pincode;
	
}
