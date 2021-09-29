package com.jpa.chapter11_web.domain;

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
}
