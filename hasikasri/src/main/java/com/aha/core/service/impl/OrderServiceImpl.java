package com.aha.core.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aha.core.domain.Order;
import com.aha.core.domain.User;
import com.aha.core.service.OrderService;
import com.aha.persistence.repository.OrderRepository;

@Service
public class OrderServiceImpl implements OrderService {

	@Autowired
	private OrderRepository repository;

	@Override
	public List<Order> getOrders(Long userId) {
		User user = new User();
		user.setId(userId);

		repository.findByUser(user);
		return null;
	}

}
