package com.jpa.jpa.Repository.orderRepository;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.JoinType;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import com.jpa.jpa.domain.QOrder;
import com.mysema.query.jpa.JPQLQuery;
import com.jpa.jpa.domain.QMember;

import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;
import org.springframework.stereotype.Repository;
import org.springframework.util.StringUtils;

import com.jpa.jpa.domain.Member;
import com.jpa.jpa.domain.Order;
import com.jpa.jpa.domain.OrderSearch;
@Repository
public class OrderRepositoryImpl extends QuerydslRepositorySupport implements OrderRepository {
	
	public OrderRepositoryImpl() {
		super(Order.class);
	}

	@PersistenceContext
	EntityManager em;
	@Override
	public void saves(Order order) {
		em.persist(order);	
	}

	@Override
	public Order findOne(Long id) {
		return em.find(Order.class, id);
	}

	@Override
	public List<Order> findAll(OrderSearch orderSearch) {
		// CriteriaBuilder cb = em.getCriteriaBuilder();
		// CriteriaQuery<Order> cq = cb.createQuery(Order.class);
		// Root<Order> o = cq.from(Order.class);

		// List<Predicate> criteria = new ArrayList<Predicate>();

		// if(orderSearch.getOrderStatus() != null){
		// 	Predicate status = cb.equal(o.get("status"), orderSearch.getOrderStatus());
		// 	criteria.add(status);
		// }
		// if(StringUtils.hasText(orderSearch.getMemberName())){
		// 	Join<Order,Member> m = o.join("member", JoinType.INNER);
		// 	Predicate name = cb.like(m.<String>get("name"), "%"+orderSearch.getMemberName()+"%");
		// 	criteria.add(name);

		// }

		// cq.where(cb.and(criteria.toArray(new Predicate[criteria.size()])));
		// TypedQuery<Order> query = em.createQuery(cq).setMaxResults(1000);
		// return query.getResultList();

		QOrder order = QOrder.order;
		QMember member = QMember.member;

		JPQLQuery query = from(order);

		if(StringUtils.hasText(orderSearch.getMemberName())){
			query.leftJoin(order.member, member).where(member.name.contains(orderSearch.getMemberName()));
		}

		if(orderSearch.getOrderStatus() != null){
			query.where(order.orderStatus.eq(orderSearch.getOrderStatus()));
		}

		return query.list(order);
	}

	
}
