package com.aha.web.dto.response;

import java.util.Date;

public class ReviewDto {

	private String review;

	private String username;

	private Double rating;

	private String addedDate;

	private String headLine;

	public ReviewDto(String review, String username, Double rating,
			Date addedDate, String headLine) {
		super();
		this.review = review;
		this.username = username;
		this.rating = rating;
		this.headLine = headLine;
		this.addedDate = getAddedDate(addedDate);
	}

	private String getAddedDate(Date addedDate2) {
		if (addedDate2 != null) {
			addedDate2.toString();
		}
		return null;
	}

	public String getReview() {
		return review;
	}

	public void setReview(String review) {
		this.review = review;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public Double getRating() {
		return rating;
	}

	public void setRating(Double rating) {
		this.rating = rating;
	}

	public String getAddedDate() {
		return addedDate;
	}

	public void setAddedDate(String addedDate) {
		this.addedDate = addedDate;
	}

	public String getHeadLine() {
		return headLine;
	}

	public void setHeadLine(String headLine) {
		this.headLine = headLine;
	}

}
