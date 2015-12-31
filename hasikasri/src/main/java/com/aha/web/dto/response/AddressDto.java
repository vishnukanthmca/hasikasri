package com.aha.web.dto.response;

import java.util.Date;

import com.aha.core.domain.Address;
import com.aha.core.domain.User;
import com.aha.core.util.Enum;

public class AddressDto {

	private String name;

	private String address;

	private Integer pincode;

	private String landmark;

	private String country;

	private String mobile;

	public AddressDto() {
		super();
	}

	public AddressDto(String name, String address, Integer pincode, String landmark, String country, String mobile) {
		super();
		this.name = name;
		this.address = address;
		this.pincode = pincode;
		this.landmark = landmark;
		this.country = country;
		this.mobile = mobile;
	}

	public AddressDto(String address2, Integer pincode2, String landmark2) {
		this.address = address2;
		this.pincode = pincode2;
		this.landmark = landmark2;
	}

	public Address getAddressInstance(User user) {
		Address instance = new Address();
		instance.setAddedDate(new Date());
		instance.setAddress(address);
		instance.setCity(null); // TODO
		instance.setCountry(Enum.Country.INDIA.ordinal());
		instance.setLandmark(landmark);
		instance.setMobile(mobile);
		instance.setName(name);
		instance.setPincode(pincode);
		instance.setUpdatedDate(new Date());
		instance.setUser(user);

		return instance;
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

	@Override
	public String toString() {
		return "AddressDto [name=" + name + ", address=" + address + ", pincode=" + pincode + ", landmark=" + landmark
				+ ", country=" + country + ", mobile=" + mobile + "]";
	}

}
