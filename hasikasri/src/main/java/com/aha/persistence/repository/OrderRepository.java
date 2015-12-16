package com.aha.persistence.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.aha.core.domain.Order;
import com.aha.core.domain.User;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {
	public List<Order> findByUser(User user);
}
