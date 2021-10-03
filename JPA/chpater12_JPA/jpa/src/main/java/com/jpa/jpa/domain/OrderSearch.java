package com.jpa.jpa.domain;

import com.jpa.jpa.domain.enumeration.OrderStatus;

import org.hibernate.annotations.Where;
import org.springframework.data.jpa.domain.Specification;

import lombok.Getter;
import lombok.Setter;
import static com.jpa.jpa.spec.OrderSpec.*;
import static org.springframework.data.jpa.domain.Specification.where;
@Getter
@Setter
public class OrderSearch {
	private String memberName;
	private OrderStatus orderStatus;

	public Specification<Order> toSpecification(){
		return where(memberNameLike(memberName)).and(orderStatusEq(orderStatus));
	}
}
