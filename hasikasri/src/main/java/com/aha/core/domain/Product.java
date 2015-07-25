package com.aha.core.domain;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@Entity
public class Product {

	@Id
	@GeneratedValue
	private Long id;

	@Column
	private String pid;
	
	@Column
	private String name;

	@ManyToOne(targetEntity = Category.class)
	private Set<Category> categories;

	@ManyToOne(targetEntity = Attribute.class)
	private Set<Attribute> attributes;
	
	@Column
	private Float discount;

	@Column
	private Double originalPrice;

	@OneToOne
	private Seller seller;
	
	
	
}
