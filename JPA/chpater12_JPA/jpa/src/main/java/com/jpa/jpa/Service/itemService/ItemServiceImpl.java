package com.jpa.jpa.Service.itemService;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jpa.jpa.Repository.itemRepository.ItemRepositoryImpl;
import com.jpa.jpa.domain.Item;
@Service
@Transactional
public class ItemServiceImpl implements ItemService{
	@Autowired
	ItemRepositoryImpl repo;
	@Override
	public void saveItem(Item item) {
		repo.saves(item);
	}

	@Override
	public List<Item> findItem() {
		return repo.findAlls();
	}

	@Override
	public Item findOne(Long itemId) {
		return repo.findOnes(itemId);
	}
	
}
