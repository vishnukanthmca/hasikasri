package com.aha.core.service;

import java.util.List;

import com.aha.core.domain.Address;
import com.aha.core.domain.User;

public interface AddressService {
	public List<Address> findByUser(User user);
	public void saveAddress(Address address);
}
