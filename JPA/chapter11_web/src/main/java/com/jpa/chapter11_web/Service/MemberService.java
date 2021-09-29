package com.jpa.chapter11_web.Service;

import java.util.List;

import com.jpa.chapter11_web.domain.Member;

public interface MemberService {
	public Long join(Member member)	;
	public void validateDuplicateMember(Member member);
	public List<Member> findMembers();
	public Member findOne(Long memberId);
}
