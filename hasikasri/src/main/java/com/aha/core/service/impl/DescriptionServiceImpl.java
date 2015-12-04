package com.aha.core.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aha.core.domain.Description;
import com.aha.core.service.DescriptionService;
import com.aha.persistence.repository.DescriptionRepository;

@Service
public class DescriptionServiceImpl implements DescriptionService {

	@Autowired
	private DescriptionRepository repository;

	@Override
	public List<Description> getdDescriptionsByProduct(Long productId) {
		return repository.getDescriptionsByProductId(productId);
	}

}
