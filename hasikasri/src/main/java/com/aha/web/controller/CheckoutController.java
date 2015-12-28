package com.aha.web.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.aha.core.domain.User;
import com.aha.core.service.UserService;

@Controller
public class CheckoutController {

	private static final String CHECKOUT_PAGE = "checkout";

	@Autowired
	private UserService userService;

	@RequestMapping(value = "/checkout")
	public ModelAndView checkout(HttpSession session) {
		ModelAndView view = new ModelAndView(CHECKOUT_PAGE);

		if (session.getAttribute("userId") != null) {
			Long userId = Long.parseLong(session.getAttribute("userId")
					.toString());

			User user = userService.findOne(userId);

			if (user == null) {
				session.invalidate();
				return view;
			}

			view.addObject("user", "hello");
		}

		return view;
	}
}
