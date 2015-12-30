package com.aha.web.dto.response;

public class AddressDto {

	private String name;

	private String address;

	private Integer pincode;

	private String landmark;

	private String country;

	private String mobile;

	public AddressDto(String name, String address, Integer pincode, String landmark, String country, String mobile) {
		super();
		this.name = name;
		this.address = address;
		this.pincode = pincode;
		this.landmark = landmark;
		this.country = country;
		this.mobile = mobile;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Integer getPincode() {
		return pincode;
	}

	public void setPincode(Integer pincode) {
		this.pincode = pincode;
	}

	public String getLandmark() {
		return landmark;
	}

	public void setLandmark(String landmark) {
		this.landmark = landmark;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

}
