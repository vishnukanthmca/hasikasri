package com.aha.core.service;

import java.util.List;

import com.aha.core.domain.Product;

public interface ProductService {

	Product findByPid(String pid);

	public List<Product> findByCategoryIds(List<Long> categoryId, Integer page);
}
