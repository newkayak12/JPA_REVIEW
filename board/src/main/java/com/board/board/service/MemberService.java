package com.board.board.service;

import com.board.board.web.dto.MemberLoginDto;

public interface MemberService {
	public int signin(MemberLoginDto member);
}
