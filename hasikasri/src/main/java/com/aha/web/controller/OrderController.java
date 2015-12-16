package com.aha.web.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.aha.core.domain.Address;
import com.aha.core.domain.Delivery;
import com.aha.core.domain.Order;
import com.aha.core.domain.Product;
import com.aha.core.service.OrderService;
import com.aha.web.dto.response.AddressDto;
import com.aha.web.dto.response.MyOrderDto;
import com.aha.web.dto.response.MyOrderItemsDto;

@Controller
public class OrderController {

	@Autowired
	private OrderService orderService;

	@RequestMapping("/myorders")
	public ModelAndView getOrders(HttpSession session) {

		ModelAndView view = new ModelAndView();

		if (session.getAttribute("userId") == null) {
			view.setViewName("home");
			return view;
		}

		Long userId = Long.parseLong(session.getAttribute("userId").toString());

		view.setViewName("myorders");

		List<Order> orders = orderService.getOrders(userId);
		if (orders != null) {

			view.addObject("orders", getOrdersList(orders));
		}

		return view;
	}

	private List<MyOrderDto> getOrdersList(List<Order> orders) {

		List<MyOrderDto> orderDtos = new ArrayList<>();

		orders.forEach(order -> {

			MyOrderDto orderDto = getMyOrderDto(order);

			if (orderDto != null && order.getOrderedItems() != null) {

				List<MyOrderItemsDto> itemsDtos = new ArrayList<>();

				order.getOrderedItems().forEach(
						item -> {

							Product product = item.getProduct();

							if (product != null) {

								String sellerName = "";
								if (product.getSeller() != null) {
									sellerName = product.getSeller().getName();
								}

								MyOrderItemsDto itemsDto = new MyOrderItemsDto(
										product.getListingImage(), product
												.getName(), product.getPrice(),
										item.getQuantity(), sellerName);
								itemsDtos.add(itemsDto);
							}
						});

				orderDto.setItems(itemsDtos);
				orderDtos.add(orderDto);
			}
		});

		return orderDtos;
	}

	private MyOrderDto getMyOrderDto(Order order) {

		if (order == null) {
			return null;
		}

		Delivery delivery = order.getDelivery();

		if (delivery == null) {
			throw new IllegalStateException(
					"Delivery must be eager fetched but not.");
		}

		AddressDto shippingAddressDto = null;
		Address shipAddress = delivery.getShippingAddress();
		if (shipAddress != null) {
			shippingAddressDto = new AddressDto(shipAddress.getStreet(),
					shipAddress.getCity().getName(), shipAddress.getState(),
					shipAddress.getAddress(), shipAddress.getPincode(),
					shipAddress.getLandmark());
		}

		AddressDto billingAddressDto = null;
		Address billingAddress = delivery.getShippingAddress();
		if (billingAddress != null) {
			billingAddressDto = new AddressDto(billingAddress.getStreet(),
					billingAddress.getCity().getName(),
					billingAddress.getState(), billingAddress.getAddress(),
					billingAddress.getPincode(), billingAddress.getLandmark());
		}

		String orderedDate = null;
		if (order.getOrderedDate() != null) {
			orderedDate = order.getOrderedDate().toString();
		}

		String deliveredDate = null;
		if (order.getDelivery().getDeliveredDate() != null) {
			deliveredDate = order.getDelivery().getDeliveredDate().toString();
		}

		MyOrderDto orderDto = new MyOrderDto(order.getOrderId(),
				delivery.getReceivedPerson(), orderedDate, order.getStatus(),
				shippingAddressDto, billingAddressDto, deliveredDate);
		return orderDto;
	}
}
