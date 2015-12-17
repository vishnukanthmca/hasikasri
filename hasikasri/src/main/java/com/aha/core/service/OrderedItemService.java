package com.aha.core.service;

import com.aha.core.domain.OrderedItem;

public interface OrderedItemService {

	public OrderedItem findByOrderItemId(String orderItemId);

	public void updateOrderedItem(OrderedItem item);
}
