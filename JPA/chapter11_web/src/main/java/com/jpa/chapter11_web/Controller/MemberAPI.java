package com.jpa.chapter11_web.Controller;

import com.jpa.chapter11_web.Service.MemberService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MemberAPI {
	@Autowired
	MemberService service;
	

}
