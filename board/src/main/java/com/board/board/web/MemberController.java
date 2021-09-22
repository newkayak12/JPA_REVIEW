package com.board.board.web;

import com.board.board.service.MemberService;
import com.board.board.web.dto.MemberLoginDto;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MemberController {
	@Autowired
	MemberService service;

	@GetMapping("/api/v1/signin/{userId}/{userPassword}")
	public int signin(@PathVariable String userId, @PathVariable String userPassword){
		
		
		return service.signin(MemberLoginDto.builder().userId(userId).userPassword(userPassword).build());
	}
	
}
