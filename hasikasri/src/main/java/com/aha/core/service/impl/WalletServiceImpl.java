package com.aha.core.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aha.core.domain.User;
import com.aha.core.domain.Wallet;
import com.aha.core.service.WalletService;
import com.aha.persistence.repository.WalletRepository;

@Service
public class WalletServiceImpl implements WalletService {

	@Autowired
	private WalletRepository walletRepository;

	@Override
	public Wallet findByUser(User user) {
		return walletRepository.findByUser(user);
	}
}
