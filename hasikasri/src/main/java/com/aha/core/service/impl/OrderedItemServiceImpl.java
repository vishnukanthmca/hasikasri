package com.aha.core.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aha.core.domain.OrderedItem;
import com.aha.core.service.OrderedItemService;
import com.aha.persistence.repository.OrderedItemRepository;

@Service
public class OrderedItemServiceImpl implements OrderedItemService {

	@Autowired
	private OrderedItemRepository repository;

	@Override
	public OrderedItem findByOrderItemId(String orderItemId) {
		return repository.findByOrderItemId(orderItemId);
	}

}
