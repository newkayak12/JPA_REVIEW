package com.jpa.chapter11_web.Service.OrderService;

import java.util.List;

import javax.transaction.Transactional;

import com.jpa.chapter11_web.Repository.memberRepository.MemberRepository;
import com.jpa.chapter11_web.Repository.orderRepository.OrderRepository;
import com.jpa.chapter11_web.Service.itemService.ItemService;
import com.jpa.chapter11_web.domain.Delivery;
import com.jpa.chapter11_web.domain.Item;
import com.jpa.chapter11_web.domain.Member;
import com.jpa.chapter11_web.domain.Order;
import com.jpa.chapter11_web.domain.OrderItem;
import com.jpa.chapter11_web.domain.OrderSearch;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class OrderServiceImpl implements OrderService{
	@Autowired MemberRepository memberRepo;
	@Autowired OrderRepository orderRepo;
	@Autowired ItemService itemService;
	@Override
	public Long order(Long memberId, Long itemId, int count) {
		Member member = memberRepo.findOne(memberId);
		Item item = itemService.findOne(itemId);

		Delivery delivery = new Delivery(member.getAddress());
		OrderItem orderItem = OrderItem.createOrderItem(item, item.getPrice(), count);
		Order order = Order.createOrder(member, delivery, orderItem);
		orderRepo.save(order);
		return order.getId();
	}

	@Override
	public void cancelOrder(Long orderId) {
		Order order = orderRepo.findOne(orderId);
		order.cancel();
	}

	@Override
	public List<Order> findOrders(OrderSearch OrderSearch) {
		return orderRepo.findAll(OrderSearch);
	}
	

}
