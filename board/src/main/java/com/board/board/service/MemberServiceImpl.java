package com.board.board.service;

import com.board.board.model.domain.member.Member;
import com.board.board.model.domain.member.MemberRepository;
import com.board.board.web.dto.MemberLoginDto;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MemberServiceImpl implements MemberService{
@Autowired
MemberRepository repo;

@Override
public int signin(MemberLoginDto member) {
	

	return repo.login(member.getUserId(), member.getUserPassword());
}
	
}
