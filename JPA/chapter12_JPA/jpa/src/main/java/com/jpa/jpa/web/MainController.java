package com.jpa.jpa.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.jpa.jpa.Service.meberService.MemberService;
@Controller
public class MainController {
	@Autowired
	MemberService service;
	@RequestMapping("/")
	public String gotoMain(){
		return "index";
	}
}
