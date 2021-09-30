package com.jpa.chapter11_web.domain;

import com.jpa.chapter11_web.domain.enumeration.OrderStatus;

import lombok.Getter;
import lombok.Setter;
@Getter
@Setter
public class OrderSearch {
	private String memberName;
	private OrderStatus orderStatus;
}
