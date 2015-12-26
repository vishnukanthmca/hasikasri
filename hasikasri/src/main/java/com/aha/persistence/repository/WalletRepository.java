package com.aha.persistence.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.aha.core.domain.User;
import com.aha.core.domain.Wallet;

public interface WalletRepository extends JpaRepository<Wallet, Long> {

	public Wallet findByUser(User user);

}
