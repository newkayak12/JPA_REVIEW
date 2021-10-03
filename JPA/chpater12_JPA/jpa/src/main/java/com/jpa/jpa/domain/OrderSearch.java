package com.jpa.jpa.domain;

import com.jpa.jpa.domain.enumeration.OrderStatus;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class OrderSearch {
	private String memberName;
	private OrderStatus orderStatus;
}
