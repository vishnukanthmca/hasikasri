package com.aha.core.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.aha.core.domain.Product;
import com.aha.core.service.ProductService;
import com.aha.persistence.repository.ProductRepository;

@Service
public class ProductServiceImpl implements ProductService {

	private static final Integer NO_OF_PRODUCTS_PER_PAGE = 9;

	@Autowired
	private ProductRepository productRepository;

	@Override
	public Product findByPid(String pid) {
		return productRepository.findByPid(pid);
	}

	public List<Product> findByCategoryIds(List<Long> categoryIds, Integer page) {

		PageRequest pageRequest = new PageRequest(page,
				NO_OF_PRODUCTS_PER_PAGE, Sort.Direction.DESC, "id");

		return productRepository.findByCategoryIds(categoryIds, pageRequest);
	}
}
