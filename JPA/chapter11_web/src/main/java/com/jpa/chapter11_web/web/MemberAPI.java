package com.jpa.chapter11_web.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.jpa.chapter11_web.Service.meberService.MemberService;

@RestController
public class MemberAPI {
	@Autowired
	MemberService service;
	

}
