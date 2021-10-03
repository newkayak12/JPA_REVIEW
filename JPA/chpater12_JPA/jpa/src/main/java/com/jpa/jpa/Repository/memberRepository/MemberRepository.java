package com.jpa.jpa.Repository.memberRepository;
import java.util.List;

import com.jpa.jpa.domain.Member;

public interface MemberRepository {

	public void save(Member member);
	public Member findOne(Long id);
	public List<Member> findAll();
	public List<Member> findByName(String name);

	
}
