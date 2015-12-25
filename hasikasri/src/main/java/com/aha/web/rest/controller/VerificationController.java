package com.aha.web.rest.controller;

import java.util.Date;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.aha.core.domain.Log;
import com.aha.core.domain.User;
import com.aha.core.service.LogService;
import com.aha.core.service.UserService;
import com.aha.core.service.VerificationService;

@Controller
public class VerificationController {

	@Autowired
	private VerificationService verificationService;

	@Autowired
	private UserService userService;

	@Autowired
	private LogService logService;

	@RequestMapping("/sendEmail")
	public @ResponseBody String sendEmail(HttpSession session,
			@RequestParam("email") String email) {

		if (session.getAttribute("userId") == null) {
			if (session != null) {
				session.invalidate();
			}
			return "unauthorized";
		}

		int code = verificationService.generateRandomNo();

		System.out.println("code " + code);

		session.setAttribute(email, code);

		if (verificationService.sendEmail(email)) {
			return "verificationcodesent";
		}

		return "true";

	}

	@RequestMapping("/sendSms")
	public @ResponseBody String sendSms(HttpSession session,
			@RequestParam("mobile") String mobile) {

		if (session.getAttribute("userId") == null) {
			if (session != null) {
				session.invalidate();
			}
			return "unauthorized";
		}

		int code = verificationService.generateRandomNo();

		System.out.println("code " + code);

		session.setAttribute(mobile, code);

		if (verificationService.sendSms(mobile)) {
			return "verificationcodesent";
		}

		return "true";
	}

	@RequestMapping("/verifyMobile")
	public @ResponseBody String verifyMobile(HttpSession session,
			@RequestParam("mobile") String mobile, String code) {

		if (session.getAttribute("userId") == null) {
			if (session != null) {
				session.invalidate();
			}
			return "unauthorized";
		}

		Integer sessionCode = (Integer) session.getAttribute(mobile);

		if (sessionCode == null) {
			if (session != null) {
				session.invalidate();
			}
			return "malfunctioned";
		}

		if (sessionCode.toString().equals(code)) {

			User user = userService.findOne(Long.parseLong(session
					.getAttribute("userId").toString()));

			if (user == null) {
				return "usernotfound";
			}

			String oldMobile = user.getMobile();

			user.setMobile(mobile);

			userService.saveUser(user);

			Log databaseLog = new Log();
			databaseLog.setActivity("User updated mobile from " + oldMobile
					+ " to " + mobile);
			databaseLog.setDate(new Date());
			databaseLog.setUser(user);

			logService.save(databaseLog);

			return "success";
		}

		return "failed";
	}

	@RequestMapping("/verifyEmail")
	public @ResponseBody String verifyEmail(HttpSession session,
			@RequestParam("email") String email, String code) {

		if (session.getAttribute("userId") == null) {
			if (session != null) {
				session.invalidate();
			}
			return "unauthorized";
		}

		Integer sessionCode = (Integer) session.getAttribute(email);

		if (sessionCode == null) {
			if (session != null) {
				session.invalidate();
			}
			return "malfunctioned";
		}

		if (sessionCode.toString().equals(code)) {

			User user = userService.findOne(Long.parseLong(session
					.getAttribute("userId").toString()));

			if (user == null) {
				return "usernotfound";
			}

			String oldEmail = user.getEmail();

			user.setEmail(email);

			userService.saveUser(user);

			Log databaseLog = new Log();
			databaseLog.setActivity("User updated email from " + oldEmail
					+ " to " + email);
			databaseLog.setDate(new Date());
			databaseLog.setUser(user);

			logService.save(databaseLog);

			return "success";
		}

		return "failed";
	}
}
