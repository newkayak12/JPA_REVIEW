package com.jpa.jpa.Service.itemService;
import java.util.List;

import com.jpa.jpa.domain.Item;

public interface ItemService {

	public void saveItem(Item item);
	public List<Item> findItem();
	public Item findOne(Long itemId);
	
}
