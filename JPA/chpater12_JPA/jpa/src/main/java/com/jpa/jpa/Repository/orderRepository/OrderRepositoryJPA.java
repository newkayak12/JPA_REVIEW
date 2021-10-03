package com.jpa.jpa.Repository.orderRepository;

import java.util.List;

import com.jpa.jpa.domain.Order;
import com.jpa.jpa.domain.OrderSearch;
import com.jpa.jpa.domain.enumeration.OrderStatus;

import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepositoryJPA extends JpaRepository<Order,Long>, OrderRepository{
}
