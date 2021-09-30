package com.jpa.chapter11_web.Service.OrderService;

import java.util.List;

import com.jpa.chapter11_web.domain.Order;
import com.jpa.chapter11_web.domain.OrderSearch;

public interface OrderService {
	public Long order(Long memberId, Long itemId, int count);
	public void cancelOrder(Long orderId);
	public List<Order> findOrders(OrderSearch OrderSearch);
}
