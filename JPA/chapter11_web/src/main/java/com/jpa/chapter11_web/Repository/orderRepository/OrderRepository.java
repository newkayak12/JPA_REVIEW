package com.jpa.chapter11_web.Repository.orderRepository;

import java.util.List;

import com.jpa.chapter11_web.domain.Order;
import com.jpa.chapter11_web.domain.OrderSearch;

public interface OrderRepository {
	
	public void save(Order order);
	public Order findOne(Long id);
	public List<Order> findAll(OrderSearch OrderSearch);
}
