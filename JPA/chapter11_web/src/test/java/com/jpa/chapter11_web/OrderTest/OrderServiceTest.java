package com.jpa.chapter11_web.OrderTest;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import com.jpa.chapter11_web.Repository.orderRepository.OrderRepository;
import com.jpa.chapter11_web.Service.OrderService.OrderService;
import com.jpa.chapter11_web.domain.Member;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(locations = "classpath:application.prorperties")
@Transactional
public class OrderServiceTest {
	@PersistenceContext
	EntityManager em;
	@Autowired
	OrderService service;
	@Autowired
	OrderRepository repo;

	@Test
	public void order(){
		// given
		// Member member = Member.builder().
	}
}
