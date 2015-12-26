package com.aha.web.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.aha.core.domain.User;
import com.aha.core.domain.Wallet;
import com.aha.core.service.UserService;
import com.aha.core.service.WalletService;

@Controller
public class WalletController {

	@Autowired
	private UserService userService;

	@Autowired
	private WalletService walletService;

	@RequestMapping(value = "/getWallet")
	public @ResponseBody String getWallet(HttpSession session) {

		if (session.getAttribute("userId") == null) {
			if (session != null) {
				session.invalidate();
			}
			return "unauthorized";
		}

		Long userId = Long.parseLong(session.getAttribute("userId").toString());

		User user = userService.findOne(userId);

		if (user == null) {
			return "unauthorized";
		}

		Wallet wallet = walletService.findByUser(user);

		if (wallet == null) {
			return "walletnotexists";
		}

		if (wallet.getAmount() == null) {
			return "noamount";
		}

		return wallet.getAmount().toString();
	}
}
