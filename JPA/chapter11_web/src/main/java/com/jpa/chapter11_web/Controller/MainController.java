package com.jpa.chapter11_web.Controller;

import com.jpa.chapter11_web.Service.MemberService;
import com.jpa.chapter11_web.domain.Member;
import com.jpa.chapter11_web.domain.embedded.Address;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
@Controller
public class MainController {
	@Autowired
	MemberService service;
	@RequestMapping("/")
	public String gotoMain(){
		Member m = Member.builder().name("name").build();
		service.join(m);
		return "index";
	}
}
