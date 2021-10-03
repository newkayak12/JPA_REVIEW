package com.jpa.jpa.Repository.memberRepository;
import java.util.List;

import com.jpa.jpa.domain.Member;

public interface MemberRepository {

	public void saves(Member member);
	public Member findOnes(Long id);
	public List<Member> findAlls();
	public List<Member> findByNames(String name);

	
}
