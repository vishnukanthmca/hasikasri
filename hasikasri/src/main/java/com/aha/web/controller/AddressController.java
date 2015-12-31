package com.aha.web.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.aha.core.domain.User;
import com.aha.core.service.AddressService;
import com.aha.core.service.UserService;
import com.aha.web.dto.response.AddressDto;

@Controller
public class AddressController {

	@Autowired
	private UserService userService;

	@Autowired
	private AddressService addressService;

	@RequestMapping(value = "/addAddress", method = RequestMethod.POST)
	public ModelAndView addAddress(HttpSession session, @ModelAttribute AddressDto dto) {

		ModelAndView view = new ModelAndView();
		view.setViewName("redirect:checkout");

		if (dto == null) {
			return view;
		}

		if (session.getAttribute("userId") == null) {
			if (session != null) {
				session.invalidate();
			}
			return view;
		}

		Long userId = Long.parseLong(session.getAttribute("userId").toString());

		User user = userService.findOne(userId);

		addressService.saveAddress(dto.getAddressInstance(user));

		return view;
	}
}
