package com.aha.web.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.aha.core.domain.Address;
import com.aha.core.domain.User;
import com.aha.core.service.AddressService;
import com.aha.core.service.UserService;
import com.aha.core.util.Enum;
import com.aha.web.dto.response.AddressDto;

@Controller
public class CheckoutController {

	private static final String CHECKOUT_PAGE = "checkout";

	@Autowired
	private UserService userService;

	@Autowired
	private AddressService addressService;

	@RequestMapping(value = "/checkout")
	public ModelAndView checkout(HttpSession session) {
		ModelAndView view = new ModelAndView(CHECKOUT_PAGE);

		if (session.getAttribute("userId") != null) {
			Long userId = Long.parseLong(session.getAttribute("userId").toString());

			User user = userService.findOne(userId);

			if (user == null) {
				session.invalidate();
				return view;
			}

			List<AddressDto> dtos = prepareAddress(addressService.findByUser(user));
			if (dtos == null || dtos.isEmpty()) {
				view.addObject("addresses", "nil");
			} else {
				view.addObject("addresses", dtos);
			}

			view.addObject("user", "hello");

		}

		return view;
	}

	private List<AddressDto> prepareAddress(List<Address> addresses) {
		List<AddressDto> dtos = new ArrayList<>();
		if (addresses != null && !addresses.isEmpty()) {
			for (Address a : addresses) {
				AddressDto dto = new AddressDto(a.getName(), a.getAddress(), a.getPincode(), a.getLandmark(),
						Enum.Country.getString(a.getCountry()), a.getMobile());
				dtos.add(dto);
			}
		}

		return dtos;
	}
}
