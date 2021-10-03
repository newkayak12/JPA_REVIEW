package com.jpa.chapter11_web.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.jpa.chapter11_web.Service.OrderService.OrderService;
import com.jpa.chapter11_web.Service.itemService.ItemService;
import com.jpa.chapter11_web.Service.meberService.MemberService;
import com.jpa.chapter11_web.domain.Item;
import com.jpa.chapter11_web.domain.Member;

@Controller
public class OrderController {
	@Autowired
	OrderService orderService;
	@Autowired
	MemberService memberService;
	@Autowired
	ItemService itemService;
	
	@RequestMapping(value = "/order", method = RequestMethod.GET)
	public String createForm(Model model) {
		List<Member> members = memberService.findMembers();
		List<Item>items = itemService.findItem();
		
		model.addAttribute("members", members);
		model.addAttribute("items", items);
		return "order/orderForm";
	}
	
	@RequestMapping(value = "/order", method = RequestMethod.POST)
	public String order(@RequestParam("memberId") Long memberId, @RequestParam("itemId") Long itemId, @RequestParam("count") int count) {
		orderService.order(memberId, itemId, count);
		return "redirect:/orders";
	}

}
