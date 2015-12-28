package com.aha.web.dto.request;

public class ChangePasswordOnCheckoutDto {

	private String emailOrMobile;

	private String newPassword;

	public String getEmailOrMobile() {
		return emailOrMobile;
	}

	public void setEmailOrMobile(String emailOrMobile) {
		this.emailOrMobile = emailOrMobile;
	}

	public String getNewPassword() {
		return newPassword;
	}

	public void setNewPassword(String newPassword) {
		this.newPassword = newPassword;
	}

	@Override
	public String toString() {
		return "ChangePasswordOnCheckoutDto [emailOrMobile=" + emailOrMobile
				+ ", newPassword=" + newPassword + "]";
	}

}
