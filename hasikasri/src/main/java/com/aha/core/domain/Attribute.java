package com.aha.core.domain;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import org.hibernate.search.annotations.Field;
import org.hibernate.search.annotations.Indexed;
import org.hibernate.search.annotations.Store;

@Entity
@Indexed
public class Attribute {

	@Id
	@GeneratedValue
	private Long id;

	@Column
	@Field(store = Store.YES)
	private String value;

	@Column
	private String refiner;

	@ManyToOne(cascade = CascadeType.ALL)
	private Product product;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getRefiner() {
		return refiner;
	}

	public void setRefiner(String refiner) {
		this.refiner = refiner;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	@Override
	public String toString() {
		return "Attribute [id=" + id + ", value=" + value + ", refiner="
				+ refiner + "]";
	}

}
