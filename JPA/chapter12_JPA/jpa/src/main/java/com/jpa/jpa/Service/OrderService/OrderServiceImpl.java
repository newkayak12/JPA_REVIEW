package com.jpa.jpa.Service.OrderService;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jpa.jpa.Repository.memberRepository.MemberRepositoryJPA;
import com.jpa.jpa.Repository.orderRepository.OrderRepositoryJPA;
import com.jpa.jpa.Service.itemService.ItemService;
import com.jpa.jpa.domain.Delivery;
import com.jpa.jpa.domain.Item;
import com.jpa.jpa.domain.Member;
import com.jpa.jpa.domain.Order;
import com.jpa.jpa.domain.OrderItem;
import com.jpa.jpa.domain.OrderSearch;

@Service
@Transactional
public class OrderServiceImpl implements OrderService{
	@Autowired MemberRepositoryJPA memberRepo;
	@Autowired OrderRepositoryJPA orderRepo;
	@Autowired ItemService itemService;
	@Override
	public Long order(Long memberId, Long itemId, int count) {
		Member member = memberRepo.findById(memberId).get();
		Item item = itemService.findOne(itemId);

		Delivery delivery = new Delivery(member.getAddress());
		OrderItem orderItem = OrderItem.createOrderItem(item, item.getPrice(), count);
		Order order = Order.createOrder(member, delivery, orderItem);
		orderRepo.save(order);
		return order.getId();
	}

	@Override
	public void cancelOrder(Long orderId) {
		Order order = orderRepo.findById(orderId).get();
		order.cancel();
	}

	@Override
	public List<Order> findOrders(OrderSearch orderSearch) {
		// return orderRepo.findAll(OrderSearch);
		// return orderRepo.(orderSearch.toSpecification());
		return orderRepo.findAll(orderSearch);
	}
	

}
