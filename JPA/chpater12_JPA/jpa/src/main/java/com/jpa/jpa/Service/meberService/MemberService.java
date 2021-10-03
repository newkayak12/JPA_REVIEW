package com.jpa.jpa.Service.meberService;

import java.util.List;

import com.jpa.jpa.domain.Member;

public interface MemberService {
	public Long join(Member member)	;
	public void validateDuplicateMember(Member member);
	public List<Member> findMembers();
	public Member findOne(Long memberId);
}
