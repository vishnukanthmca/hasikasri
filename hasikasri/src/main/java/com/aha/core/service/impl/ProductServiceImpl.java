package com.aha.core.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aha.core.domain.Product;
import com.aha.core.service.ProductService;
import com.aha.persistence.repository.ProductRepository;

@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	private ProductRepository productRepository;

	@Override
	public Product findByPid(String pid) {
		return productRepository.findByPid(pid);
	}
}
