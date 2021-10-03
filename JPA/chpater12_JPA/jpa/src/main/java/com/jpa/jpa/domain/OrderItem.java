package com.jpa.jpa.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder

@Entity
public class OrderItem {
	@Id
	@GeneratedValue
	@Column(name = "ORDER_ITEM_ID")
	private Long id;

	// @
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ITEM_ID")
	private Item item;


	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "Order_id")
	private Order order;

	private int orderPrice;

	private int count;
	/*
		이렇게 엔티티가 비즈니스 로직을 객체지향의 특성을 적응 활용하는 것이 도메인 모델 패턴이다. 
		반대로 엔티티에는 비즈니스 로직이 거의 없고 서비스 계층에서 대부분 처리하면 트랜젝션 스크립트 패턴이다. 
	*/

	public static OrderItem createOrderItem(Item item, int orderPrice, int count){
		OrderItem orderItem = new OrderItem();
		orderItem.setItem(item);
		orderItem.setOrderPrice(orderPrice);
		orderItem.setCount(count);
		item.removeStock(count);
		return orderItem;

	}

	public void cancel(){
		getItem().addStock(count);
	}

	public int getTotalPrice(){
		return getOrderPrice()*getCount();
	}
}
