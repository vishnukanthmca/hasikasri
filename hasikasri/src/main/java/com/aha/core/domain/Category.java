package com.aha.core.domain;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Category {

	@Id
	@GeneratedValue
	private Long id;

	@Column
	private String name;

	@Column
	private Boolean active;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "parent_id")
	private Category parentCategory;

	@OneToMany(fetch = FetchType.EAGER)
	private List<Product> products;

	@OneToMany(mappedBy = "parentCategory", fetch = FetchType.EAGER)
	private List<Category> childrenCategories;

	@Column
	@Temporal(TemporalType.DATE)
	private Date temporaryDate;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Category getParentCategory() {
		return parentCategory;
	}

	public void setParentCategory(Category parentCategory) {
		this.parentCategory = parentCategory;
	}

	public Boolean getActive() {
		return active;
	}

	public void setActive(Boolean active) {
		this.active = active;
	}

	public List<Product> getProducts() {
		return products;
	}

	public void setProducts(List<Product> products) {
		this.products = products;
	}

	public Date getTemporaryDate() {
		return temporaryDate;
	}

	public void setTemporaryDate(Date temporaryDate) {
		this.temporaryDate = temporaryDate;
	}

	public List<Category> getChildrenCategories() {
		return childrenCategories;
	}

	public void setChildrenCategories(List<Category> childrenCategories) {
		this.childrenCategories = childrenCategories;
	}

	@Override
	public String toString() {
		return "Category [id=" + id + ", name=" + name + ", active=" + active
				+ ", parentCategory=" + parentCategory + "]";
	}

}
