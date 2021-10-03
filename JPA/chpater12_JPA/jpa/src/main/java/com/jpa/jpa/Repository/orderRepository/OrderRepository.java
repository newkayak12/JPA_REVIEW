package com.jpa.jpa.Repository.orderRepository;

import java.util.List;

import com.jpa.jpa.domain.Order;
import com.jpa.jpa.domain.OrderSearch;

public interface OrderRepository {
	
	public void save(Order order);
	public Order findOne(Long id);
	public List<Order> findAll(OrderSearch OrderSearch);
}
