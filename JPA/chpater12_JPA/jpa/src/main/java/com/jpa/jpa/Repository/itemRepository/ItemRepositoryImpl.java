package com.jpa.jpa.Repository.itemRepository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import lombok.RequiredArgsConstructor;

import com.jpa.jpa.domain.Item;
// @Repository
@RequiredArgsConstructor
public class ItemRepositoryImpl implements ItemRepository {
	@PersistenceContext
	EntityManager em;
	@Override
	public void saves(Item item) {
		if(item.getId() == null){
			em.persist(item);
		} else {
			em.merge(item);
			// 준영속 상태의 엔티티를 수정할 때 사용한다. 영속 상태의 엔티티는 변경 감지 기능이 동작하지만,
		}
	}

	@Override
	public Item findOne(Long id) {
		return em.find(Item.class, id);
	}

	@Override
	public List<Item> findAll() {
		return em.createQuery("SELECT i  FROM Item i", Item.class).getResultList();
	}
	
}
