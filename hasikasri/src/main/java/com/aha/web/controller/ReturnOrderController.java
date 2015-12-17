package com.aha.web.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.aha.web.dto.request.ReturnInputDto;

@Controller
public class ReturnOrderController {

	@RequestMapping(value = "/return")
	public ModelAndView returnItem(
			@ModelAttribute("return") ReturnInputDto dto, HttpSession session) {

		ModelAndView view = new ModelAndView();

		if (session.getAttribute("userId") == null) {
			view.setViewName("home");
			return view;
		}

		view.setViewName("myorders");

		return view;
	}
}
