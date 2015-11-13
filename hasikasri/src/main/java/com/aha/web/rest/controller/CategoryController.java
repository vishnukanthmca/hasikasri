package com.aha.web.rest.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.aha.core.domain.Category;
import com.aha.core.service.CategoryService;
import com.aha.web.dto.BreadcrumbDto;
import com.aha.web.dto.CategoryDto;
import com.google.gson.Gson;

@RestController
@RequestMapping("/category")
public class CategoryController {

	@Autowired
	private CategoryService categoryService;

	@RequestMapping(value = "/getCategory", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody String getCategoryById(@RequestBody Long id) {

		long start = System.currentTimeMillis();

		Category category = categoryService.findActiveCategories(id);

		CategoryDto categoriesDto = null;
		if (category != null) {
			categoriesDto = print(category);
			categoriesDto.setBreadcrumps(getParents(category));
		}

		Gson gson = new Gson();
		String json = gson.toJson(categoriesDto);
		System.out.println("end time " + (System.currentTimeMillis() - start));
		return json;
	}

	private List<BreadcrumbDto> getParents(Category category) {

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

	/**
	 * Supports ONLY 3 levels
	 * 
	 * @param category
	 * @return
	 */
	public CategoryDto print(Category category) {

		Integer categoryCount = 0;

		List<Long> childrenIdsList = new ArrayList<>();

		CategoryDto dto = null;

		if (category != null) {

			dto = new CategoryDto(category.getId(), category.getName(),
					category.getParentCategory());

			childrenIdsList.add(category.getId());

			if (category.getChildrenCategories() != null) {

				List<Category> subCategories = category.getChildrenCategories();
				List<CategoryDto> sub1Dtos = new ArrayList<>();

				if (subCategories != null) {

					categoryCount += 1;

					for (Category subCategory : subCategories) {

						CategoryDto sub1Dto = new CategoryDto(
								subCategory.getId(), subCategory.getName(),
								subCategory.getParentCategory());

						sub1Dtos.add(sub1Dto);

						childrenIdsList.add(subCategory.getId());

						List<CategoryDto> sub2Dtos = new ArrayList<>();
						List<Category> sub2Categories = subCategory
								.getChildrenCategories();
						if (sub2Categories != null) {

							categoryCount += 1;

							for (Category sub2Category : sub2Categories) {
								CategoryDto sub2Dto = new CategoryDto(
										sub2Category.getId(),
										sub2Category.getName(),
										sub2Category.getParentCategory());

								sub2Dtos.add(sub2Dto);

								childrenIdsList.add(sub2Category.getId());

								List<CategoryDto> sub3Dtos = new ArrayList<>();
								List<Category> sub3Categories = sub2Category
										.getChildrenCategories();
								if (sub3Categories != null) {
									categoryCount += 1;
									for (Category sub3Category : sub3Categories) {

										CategoryDto sub3Dto = new CategoryDto(
												sub3Category.getId(),
												sub3Category.getName(),
												sub3Category
														.getParentCategory());
										sub3Dtos.add(sub3Dto);

										childrenIdsList.add(sub3Category
												.getId());
									}
								}
								sub2Dto.setChildren(sub3Dtos);
							}
						}
						sub1Dto.setChildren(sub2Dtos);
					}
					dto.setChildren(sub1Dtos);
				}
			}
		}

		dto.setChildrenIds(childrenIdsList);

		System.out.println("categoryCount " + categoryCount);

		return dto;
	}
}
