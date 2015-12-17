package com.aha.core.service;

import java.util.List;

import com.aha.core.domain.Order;

public interface OrderService {

	public List<Order> getOrders(Long userId, Integer status);

	public List<Order> getOrders(Long userId);
}
