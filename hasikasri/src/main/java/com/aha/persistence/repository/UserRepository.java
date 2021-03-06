package com.aha.persistence.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.aha.core.domain.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

	public User findByEmail(String email);

	public User findByMobile(String mobile);

	public User findByEmailAndPassword(String email, String password);

	public User findByMobileAndPassword(String mobile, String password);
}
