package com.jpa.chapter11_web.Repository.itemRepository;

import java.util.List;

import com.jpa.chapter11_web.domain.Item;

public interface ItemRepository {
	public void save(Item item);
	public Item findOne(Long id);
	public List<Item> findAll();
}
