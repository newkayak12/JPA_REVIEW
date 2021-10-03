package com.jpa.jpa.spec;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.JoinType;
import javax.persistence.criteria.Root;

import com.google.common.base.Predicate;
import com.jpa.jpa.domain.Member;
import com.jpa.jpa.domain.Order;
import com.jpa.jpa.domain.enumeration.OrderStatus;

import org.hibernate.Criteria;
import org.springframework.data.jpa.domain.Specification;

import antlr.StringUtils;

public class OrderSpec {
	public static Specification<Order> memberNameLike(final String memberName){
		return new Specification<Order>(){
			public javax.persistence.criteria.Predicate toPredicate(Root<Order> root,  CriteriaQuery<?> query, CriteriaBuilder builder){
				if(org.springframework.util.StringUtils.isEmpty(memberName)) return null;

				Join<Order,Member> m = root.join("member",JoinType.INNER);
				return builder.like(m.<String>get("name"), "%"+memberName+"%");
			}
		};
	}
	public static Specification<Order> orderStatusEq(final OrderStatus orderStatus){
		return new Specification<Order>(){
			public javax.persistence.criteria.Predicate toPredicate(Root<Order> root, CriteriaQuery<?> query, CriteriaBuilder builder) {
				if(orderStatus == null) return null;
				return builder.equal(root.get("status"), orderStatus);
			}
		};
	}
}


