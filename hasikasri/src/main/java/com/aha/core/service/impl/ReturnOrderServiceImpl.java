package com.aha.core.service.impl;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aha.core.domain.OrderedItem;
import com.aha.core.domain.ReturnOrder;
import com.aha.core.domain.User;
import com.aha.core.service.OrderedItemService;
import com.aha.core.service.ReturnOrderService;
import com.aha.core.util.Enum.OrderStatus;
import com.aha.persistence.repository.ReturnOrderRepository;
import com.aha.web.dto.request.ReturnInputDto;

@Service
public class ReturnOrderServiceImpl implements ReturnOrderService {

	@Autowired
	private ReturnOrderRepository repository;

	@Autowired
	private OrderedItemService orderedItemService;

	@Override
	public void save(ReturnInputDto dto, Long userId) {

		OrderedItem orderedItem = getOrderedItem(dto);
		ReturnOrder returnOrder = createReturnOrderEntity(orderedItem, dto,
				userId);
		repository.save(returnOrder);

		orderedItem
				.setStatus(OrderStatus.RETURN_ORDER_REQUEST_PLACED.ordinal());

		orderedItem.setReturnOrder(returnOrder);
		orderedItemService.updateOrderedItem(orderedItem);
	}

	public ReturnOrder createReturnOrderEntity(OrderedItem orderedItem,
			ReturnInputDto dto, Long userId) {

		User user = new User();
		user.setId(userId);

		ReturnOrder order = new ReturnOrder();
		order.setComments(dto.getComment());

		order.setOrderedItem(orderedItem);
		order.setUser(user);
		order.setReturnDate(new Date());

		return order;
	}

	private OrderedItem getOrderedItem(ReturnInputDto dto) {
		OrderedItem orderedItem = orderedItemService.findByOrderItemId(dto
				.getOrderItemId());
		if (orderedItem == null) {
			throw new IllegalStateException(
					"OrderedItem is null which should not be.");
		}
		return orderedItem;
	}
}
