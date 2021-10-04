package com.jpa.jpa.Service.OrderService;

import java.util.List;

import com.jpa.jpa.domain.Order;
import com.jpa.jpa.domain.OrderSearch;

public interface OrderService {
	public Long order(Long memberId, Long itemId, int count);
	public void cancelOrder(Long orderId);
	public List<Order> findOrders(OrderSearch OrderSearch);
}
