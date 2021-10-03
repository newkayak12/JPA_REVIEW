package com.jpa.jpa.Repository.itemRepository;

import com.jpa.jpa.domain.Item;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemRepositoryJPA extends JpaRepository<Item,Long>, ItemRepository{
	// custom에  jpaRepository를 구현하면 impl 에도 구현해야한다.
}
