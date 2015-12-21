package com.aha.core.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aha.core.domain.Review;
import com.aha.core.service.ReviewService;
import com.aha.persistence.repository.ReviewRepository;

@Service
public class ReviewServiceImpl implements ReviewService {

	@Autowired
	private ReviewRepository repository;

	@Override
	public List<Review> getReviewsForProduct(Long productId) {

		return repository.findByProduct(productId);
	}

}
