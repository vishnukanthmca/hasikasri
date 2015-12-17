package com.aha.core.service.impl;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aha.core.domain.OrderedItem;
import com.aha.core.domain.ReturnOrder;
import com.aha.core.domain.User;
import com.aha.core.service.OrderedItemService;
import com.aha.core.service.ReturnOrderService;
import com.aha.core.util.Enum.ReturnOrderStatus;
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
		repository.save(createReturnOrderEntity(dto, userId));
	}

	public ReturnOrder createReturnOrderEntity(ReturnInputDto dto, Long userId) {

		OrderedItem orderedItem = orderedItemService.findByOrderItemId(dto
				.getOrderItemId());
		if (orderedItem == null) {
			throw new IllegalStateException(
					"OrderedItem is null which should not be.");
		}

		User user = new User();
		user.setId(userId);

		ReturnOrder order = new ReturnOrder();
		order.setComments(dto.getComment());

		order.setOrderedItem(orderedItem);
		order.setUser(user);
		order.setReturnDate(new Date());
		order.setStatus(ReturnOrderStatus.RETURN_ORDER_REQUEST_PLACED.ordinal());

		return order;
	}
}
