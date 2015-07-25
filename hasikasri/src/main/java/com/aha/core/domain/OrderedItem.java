package com.aha.core.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class OrderedItem {

	@Id
	@GeneratedValue
	private Long id;

	@OneToOne(targetEntity = Product.class)
	private Product product;

	@Column
	private Integer quantity;

	@Column
	private Float discount;
	
}
