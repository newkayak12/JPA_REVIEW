package com.jpa.chapter11_web.Service.itemService;

import java.util.List;

import com.jpa.chapter11_web.domain.Item;

public interface ItemService {

	public void saveItem(Item item);
	public List<Item> findItem();
	public Item findOne(Long itemId);
	
}
