package com.aha.web.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.aha.core.domain.Category;
import com.aha.core.domain.Description;
import com.aha.core.domain.Image;
import com.aha.core.domain.Product;
import com.aha.core.service.CategoryService;
import com.aha.core.service.DescriptionService;
import com.aha.core.service.ImageService;
import com.aha.core.service.ProductService;
import com.aha.core.util.Util;
import com.aha.web.dto.response.BreadcrumbDto;
import com.aha.web.dto.response.DescriptionDto;
import com.aha.web.dto.response.ImageDto;
import com.aha.web.dto.response.ProductDetailDto;

@Controller
public class ProductDetailsController {

	private static final String DETAIL_PAGE = "detail";

	@Autowired
	private ProductService productService;

	@Autowired
	private ImageService imageService;

	@Autowired
	private DescriptionService descriptionService;

	@Autowired
	private CategoryService categoryService;

	@RequestMapping(value = "/detail", method = RequestMethod.POST)
	public ModelAndView detail(Long productId) {

		ModelAndView modelAndView = new ModelAndView(DETAIL_PAGE);

		if (productId != null) {
			Product product = productService.findById(productId);

			if (product == null) {
				modelAndView.setViewName("error");
			} else {
				ProductDetailDto dto = new ProductDetailDto(product.getName(),
						getImages(productId), product.getRating(),
						product.getActualPrice(), product.getPrice(),
						product.getDiscount(), getDescription(productId),
						getBreadCrumbs(productId));

				modelAndView.addObject("product", dto);
			}
		}

		return modelAndView;
	}

	private List<BreadcrumbDto> getBreadCrumbs(Long productId) {
		Category category = categoryService.findByProductId(productId);

		if (category != null) {
			return Util.getParents(category);
		}

		return null;
	}

	private List<DescriptionDto> getDescription(Long productId) {
		List<Description> descriptions = descriptionService
				.getdDescriptionsByProduct(productId);

		List<DescriptionDto> dtos = new ArrayList<>();

		if (descriptions != null && !descriptions.isEmpty()) {
			for (Description d : descriptions) {
				DescriptionDto dto = new DescriptionDto(d.getType(),
						d.getDescription());

				dtos.add(dto);
			}
		}

		return dtos;
	}

	private List<ImageDto> getImages(Long productId) {
		List<Image> images = imageService.getImagesByProductId(productId);
		List<ImageDto> dtos = new ArrayList<ImageDto>();
		if (images != null && !images.isEmpty()) {
			for (Image image : images) {
				ImageDto dto = new ImageDto(image, productId);
				dtos.add(dto);
			}
		}
		return dtos;
	}
}
