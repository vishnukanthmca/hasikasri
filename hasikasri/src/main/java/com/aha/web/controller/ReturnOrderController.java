package com.aha.web.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.aha.core.service.ReturnOrderService;
import com.aha.web.dto.request.ReturnInputDto;

@Controller
public class ReturnOrderController {

	@Autowired
	private ReturnOrderService returnOrderService;

	@RequestMapping(value = "/return")
	public ModelAndView returnItem(
			@ModelAttribute("return") ReturnInputDto dto, HttpSession session) {

		ModelAndView view = new ModelAndView();

		if (session.getAttribute("userId") == null) {
			view.setViewName("home");
			return view;
		}

		returnOrderService.save(dto,
				Long.parseLong(session.getAttribute("userId").toString()));

		view.setViewName("myorders");

		return view;
	}
}
