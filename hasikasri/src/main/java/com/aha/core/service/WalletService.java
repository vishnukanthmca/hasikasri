package com.aha.core.service;

import com.aha.core.domain.User;
import com.aha.core.domain.Wallet;

public interface WalletService {

	public Wallet findByUser(User user);
}
