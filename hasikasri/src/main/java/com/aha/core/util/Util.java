package com.aha.core.util;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.domain.Sort.Direction;

import com.aha.core.domain.Category;
import com.aha.web.dto.response.BreadcrumbDto;
import com.lambdaworks.crypto.SCryptUtil;

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

	public static List<BreadcrumbDto> getParents(Category category) {

		List<BreadcrumbDto> breadcrumps = new ArrayList<>();

		if (category != null) {

			BreadcrumbDto bto = new BreadcrumbDto();
			bto.setId(category.getId());
			bto.setName(category.getName());
			breadcrumps.add(bto);

			Category parentCategory = category.getParentCategory();

			if (parentCategory != null) {

				BreadcrumbDto bto1 = new BreadcrumbDto();
				bto1.setId(parentCategory.getId());
				bto1.setName(parentCategory.getName());

				breadcrumps.add(bto1);

				Category grandParentCategory = parentCategory
						.getParentCategory();

				if (grandParentCategory != null) {

					BreadcrumbDto bto2 = new BreadcrumbDto();
					bto2.setId(grandParentCategory.getId());
					bto2.setName(grandParentCategory.getName());
					breadcrumps.add(bto2);
				}
			}
		}

		java.util.Collections.reverse(breadcrumps);

		return breadcrumps;
	}

	public static String encodePassword(String password) {
		return SCryptUtil.scrypt(password, 16, 16, 16);
	}

	public static boolean decodePassword(String password, String hash) {
		return SCryptUtil.check(password, hash);
	}
}
