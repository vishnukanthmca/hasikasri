package com.aha.web.dto.response;

public class AddressDto {

	private String street;

	private String city;

	private String state;

	private String address;

	private Integer pincode;

	private String landmark;

	public AddressDto(String street, String city, String state, String address,
			Integer pincode, String landmark) {
		super();
		this.street = street;
		this.city = city;
		this.state = state;
		this.address = address;
		this.pincode = pincode;
		this.landmark = landmark;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
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

}
