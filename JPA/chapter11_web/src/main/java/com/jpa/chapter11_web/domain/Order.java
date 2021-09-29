package com.jpa.chapter11_web.domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.jpa.chapter11_web.domain.enumeration.OrderStatus;

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
@Table(name = "ORDERS")
public class Order {
	@Id
	@GeneratedValue
	@Column(name ="ORDER_ID")
	private Long id;

	@ManyToOne
	@JoinColumn(name = "MEMBER_ID")
	private Member member;

	// ORDER_ITEM
	@OneToMany(mappedBy = "order", cascade = CascadeType.ALL)
	private List<OrderItem> orderItems = new ArrayList<>();

	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name = "DELIVERY_ID")
	private Delivery delivery;
		

	@Temporal(TemporalType.TIMESTAMP)
	private Date date;

	@Enumerated(EnumType.STRING)
	private OrderStatus orderStatus;

	public void addMember(Member member){
		if(this.member != null){
			member.getOrders().remove(this);
		}
		this.member = member;
		member.getOrders().add(this);
	}
	public void addOrderItem(OrderItem orderItem){
		if(orderItem.getOrder()!= null){
			orderItems.remove(orderItem);
		}
		orderItems.add(orderItem);
		orderItem.setOrder(this);
	}
	public void addDelivery(Delivery delivery){
		this.delivery = delivery;
		delivery.setOrder(this);
	}

}
