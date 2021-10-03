package com.jpa.jpa.Repository.itemRepository;

import java.util.List;

import com.jpa.jpa.domain.Item;

public interface ItemRepositoryCustom {
	public void saves(Item item);
	public Item findOnes(Long id);
	public List<Item> findAlls();
}
