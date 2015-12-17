package com.aha.persistence.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.aha.core.domain.OrderedItem;

@Repository
public interface OrderedItemRepository extends JpaRepository<OrderedItem, Long> {

	public OrderedItem findByOrderItemId(String orderItemId);
}
