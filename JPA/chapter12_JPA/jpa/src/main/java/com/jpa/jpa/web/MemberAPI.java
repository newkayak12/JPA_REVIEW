package com.jpa.jpa.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.jpa.jpa.Service.meberService.MemberService;

@RestController
public class MemberAPI {
	@Autowired
	MemberService service;
	

}
