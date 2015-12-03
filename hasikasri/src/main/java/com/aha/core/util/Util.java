package com.aha.core.util;

import org.springframework.data.domain.Sort.Direction;

public class Util {

	public enum Sort {

		PRICE_HIGH_TO_LOW("Price: High To Low"), PRICE_LOW_TO_HIGH(
				"Price: Low To High"), DISCOUNT("Discount: High To Low"), WHATS_NEW(
				"What's New");

		String s;

		Sort(String s) {
			this.s = s;
		}

		public String getSort() {
			return s;
		}
	}

	public static String getSortColumn(Sort sort) {

		String column = "addedDate";

		switch (sort) {
		case PRICE_HIGH_TO_LOW:
			column = "price";
			break;
		case PRICE_LOW_TO_HIGH:
			column = "price";
			break;
		case WHATS_NEW:
			column = "addedDate";
			break;
		case DISCOUNT:
			column = "discount";
			break;
		}

		return column;
	}

	public static Direction getSortOrder(Sort sort) {

		Direction column = org.springframework.data.domain.Sort.Direction.DESC;

		switch (sort) {
		case PRICE_HIGH_TO_LOW:
			column = org.springframework.data.domain.Sort.Direction.DESC;
			break;
		case PRICE_LOW_TO_HIGH:
			column = org.springframework.data.domain.Sort.Direction.ASC;
			break;
		case WHATS_NEW:
			column = org.springframework.data.domain.Sort.Direction.DESC;
			break;
		case DISCOUNT:
			column = org.springframework.data.domain.Sort.Direction.DESC;
			break;
		}

		return column;
	}

	public static Integer calculateOff(Double price, Double actualPrice) {

		if (price == null || actualPrice == null) {
			return null;
		}

		return (int) Math.floor(100 - ((price / actualPrice) * 100));
	}

}
