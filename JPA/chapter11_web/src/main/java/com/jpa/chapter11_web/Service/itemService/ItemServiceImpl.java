package com.jpa.chapter11_web.Service.itemService;

import java.util.List;

import javax.transaction.Transactional;

import com.jpa.chapter11_web.Repository.itemRepository.ItemRepositoryImpl;
import com.jpa.chapter11_web.domain.Item;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
@Transactional
public class ItemServiceImpl implements ItemService{
	@Autowired
	ItemRepositoryImpl repo;
	@Override
	public void saveItem(Item item) {
		repo.save(item);
	}

	@Override
	public List<Item> findItem() {
		return repo.findAll();
	}

	@Override
	public Item findOne(Long itemId) {
		return repo.findOne(itemId);
	}
	
}
