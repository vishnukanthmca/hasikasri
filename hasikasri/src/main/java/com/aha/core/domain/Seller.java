package com.aha.core.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Seller {

	@Id
	@GeneratedValue
	private Long id;

	@Column
	private String name;
	
	@OneToOne
	private Address address;
	
	
}
