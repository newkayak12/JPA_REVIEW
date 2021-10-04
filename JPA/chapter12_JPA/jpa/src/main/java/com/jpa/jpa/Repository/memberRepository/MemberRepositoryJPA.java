package com.jpa.jpa.Repository.memberRepository;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

import com.jpa.jpa.domain.Member;

public interface MemberRepositoryJPA extends JpaRepository<Member, Long> {
	List<Member> findByName(String name);
}
