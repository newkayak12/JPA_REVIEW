package com.jpa.chapter11_web.Repository.itemRepository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.jpa.chapter11_web.domain.Item;

import org.springframework.stereotype.Repository;
@Repository
public class ItemRepositoryImpl implements ItemRepository {
	@PersistenceContext
	EntityManager em;
	@Override
	public void save(Item item) {
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
