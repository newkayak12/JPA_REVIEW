package com.jpa.jpa.Repository.itemRepository;

import java.util.List;

import com.jpa.jpa.domain.Item;
import org.springframework.data.jpa.repository.JpaRepository;
public interface ItemRepository {
	public void saves(Item item);
	public Item findOne(Long id);
	public List<Item> findAll();
}
