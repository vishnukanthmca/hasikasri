package com.aha.core.service;

import java.util.List;

import com.aha.core.domain.Review;

public interface ReviewService {

	public List<Review> getReviewsForProduct(Long productId);
}
