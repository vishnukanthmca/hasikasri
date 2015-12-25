package com.aha.core.service.impl;

import java.util.concurrent.ThreadLocalRandom;

import org.springframework.stereotype.Service;

import com.aha.core.service.VerificationService;

@Service
public class VerificationServiceImpl implements VerificationService {

	@Override
	public boolean verifyMobile(String mobile) {
		// TODO - implement mobile verification code
		return true;
	}

	@Override
	public int generateRandomNo() {
		return ThreadLocalRandom.current().nextInt(1000, 9999);
	}

	@Override
	public boolean sendSms(String mobile) {
		// TODO implement sms code
		return true;
	}

	@Override
	public boolean sendEmail(String email) {
		// TODO implement email code
		return true;
	}

}
