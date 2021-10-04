package com.jpa.jpa.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.jpa.jpa.Service.itemService.ItemService;
import com.jpa.jpa.domain.Item;
import com.jpa.jpa.domain.discriminatedValue.item.Book;
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
