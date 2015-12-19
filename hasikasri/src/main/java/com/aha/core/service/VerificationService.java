package com.aha.core.service;

public interface VerificationService {

	public boolean verifyMobile(String mobile);

	public int generateRandomNo();

	public boolean sendSMS(String mobile);
}
