package com.aha.core.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aha.core.domain.Address;
import com.aha.core.domain.User;
import com.aha.core.service.AddressService;
import com.aha.persistence.repository.AddressRepository;

@Service
public class AddressServiceImpl implements AddressService {

	@Autowired
	private AddressRepository addressRepository;

	@Override
	public List<Address> findByUser(User user) {
		return addressRepository.findAddresses(user);
	}

	@Override
	public void saveAddress(Address address) {
		addressRepository.save(address);
	}
}
