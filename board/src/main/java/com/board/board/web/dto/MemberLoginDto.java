package com.board.board.web.dto;

import com.board.board.model.domain.member.Member;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class MemberLoginDto {
	private String userId, userPassword;

	public Member toEntity(){
		return Member.builder().userId(userId).userPassword(userPassword).build();
	}
}
