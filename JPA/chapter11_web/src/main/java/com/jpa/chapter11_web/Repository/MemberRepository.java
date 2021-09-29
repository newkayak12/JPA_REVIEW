package com.jpa.chapter11_web.Repository;

import java.util.List;

import com.jpa.chapter11_web.domain.Member;

public interface MemberRepository {

	public void save(Member member);
	public Member findOne(Long id);
	public List<Member> findAll();
	public List<Member> findByName(String name);

	
}
