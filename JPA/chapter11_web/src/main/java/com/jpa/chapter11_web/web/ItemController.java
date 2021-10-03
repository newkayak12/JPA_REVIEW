package com.jpa.chapter11_web.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.jpa.chapter11_web.Service.itemService.ItemService;
import com.jpa.chapter11_web.domain.Item;
import com.jpa.chapter11_web.domain.discriminatedValue.item.Book;
@Controller
public class ItemController {

	@Autowired
	ItemService service;
	
	@RequestMapping(value = "/items", method = RequestMethod.GET)
	public String list(Model model) {
		List<Item> items = service.findItem();
		model.addAttribute("items",items);
		return "items/itemsList";
	}	

	@RequestMapping(value = "/items/{itemsId}/edit", method = RequestMethod.GET)
	public String updateItemForm(@PathVariable("itemId") Long itemId, Model model) {
		
		Item item = service.findOne(itemId);
		model.addAttribute("item", item);
		return "items/updateItemForm";
	}
	@RequestMapping(value = "/itmes/{itemId}/edit", method = RequestMethod.POST)
	public String updateItem(@ModelAttribute("item") Book item) {
		service.saveItem(item);
/*
 * 	준영속 상태 수정하는 방법은 1. 변경감지 2. 병합 사용
 * 
 * 1.준영속 상태인 것을 select해서 영속으로 만들고 바꿔서 변경 감지를 사용하거나
 * 2. em.merge()로 그 안의 모든 값을 변경하거나 
 */
		return "redirect:/items";
	}
	
	
	
	@RequestMapping(value ="/itmes/new", method=RequestMethod.GET)
	public String createForm(){
		return "itmes/createItemForm";
	}
	@RequestMapping(value = "/items/new", method = RequestMethod.POST)
	public String create(Book item){
		service.saveItem(item);
		return "redirect:/itmes";
	}
	
}
