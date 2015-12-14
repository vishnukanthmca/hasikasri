package com.aha.web.rest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.aha.core.service.ReviewService;

@RestController
@RequestMapping(value = "/review")
public class ReviewController {

	@Autowired
	private ReviewService reviewService;

	@RequestMapping("/getReviews")
	public String getReviewsForProduct(@RequestParam("productId") Long productId) {

		reviewService.getReviewsForProduct(productId);

		return null;
	}
}
