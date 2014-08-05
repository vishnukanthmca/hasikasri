package com.hasikasri.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hasikasri.core.domain.User;

public interface UserRepository extends JpaRepository<User, Long> {
	public User findByUsernameAndPassword(User user);
}
