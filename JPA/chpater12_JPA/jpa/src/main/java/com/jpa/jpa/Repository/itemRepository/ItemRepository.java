package com.jpa.jpa.Repository.itemRepository;

import com.jpa.jpa.domain.Item;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemRepository extends JpaRepository<Item,Long>, ItemRepositoryCustom {
	
}
