package com.aha.web.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.aha.core.domain.Image;
import com.aha.core.domain.Product;
import com.aha.core.service.ImageService;
import com.aha.core.service.ProductService;
import com.aha.web.dto.response.ImageDto;
import com.aha.web.dto.response.ProductDetailDto;

@Controller
public class HomeController {

	private static final String HOME_PAGE = "home";
	private static final String LISTING_PAGE = "listing";
	private static final String DETAIL_PAGE = "detail";
	private static final String ERROR_PAGE = "error";

	@Autowired
	private ProductService productService;

	@Autowired
	private ImageService imageService;

	@RequestMapping(value = "/home")
	public ModelAndView home() {
		ModelAndView modelAndView = new ModelAndView(HOME_PAGE);
		return modelAndView;
	}

	@RequestMapping(value = "/listing")
	public ModelAndView listing() {
		ModelAndView modelAndView = new ModelAndView(LISTING_PAGE);
		return modelAndView;
	}

	@RequestMapping(value = "/error")
	public ModelAndView error() {
		ModelAndView modelAndView = new ModelAndView(ERROR_PAGE);
		return modelAndView;
	}

	@RequestMapping(value = "/detail", method = RequestMethod.POST)
	public ModelAndView detail(Long productId) {

		ModelAndView modelAndView = new ModelAndView(DETAIL_PAGE);

		if (productId != null) {
			Product product = productService.findById(productId);

			if (product == null) {
				modelAndView.setViewName("error");
			} else {

				ProductDetailDto dto = new ProductDetailDto(product.getName(),
						getImages(productId));
				modelAndView.addObject("product", dto);
			}
		}

		return modelAndView;
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
