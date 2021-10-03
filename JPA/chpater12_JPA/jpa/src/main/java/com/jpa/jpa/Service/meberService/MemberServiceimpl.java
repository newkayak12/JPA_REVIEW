package com.jpa.jpa.Service.meberService;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jpa.jpa.Repository.memberRepository.MemberRepository;
import com.jpa.jpa.domain.Member;

import lombok.extern.slf4j.Slf4j;
@Service
@Transactional
/*
   스프링 프레임워크는 이 어노테이션이 붙어있느 ㄴ클래스나 메소드에 ㅈ트랜잭션을 적용한다. 외부에서 이 클래스의 메소드를 호출할 때 트랜잭션을 시작하고 메소드를 종료할 떄 트랜잭션을 커밋한다. 
   만약 예외가 발생하면 트랜잭션을 롤백한다. 
   특히 RuntimeException, Unchecked 예외만 롤백한다. 
   체크 예외에도 롤백하고 싶으면 @Transactional(rollbackFor = Exception.class)로 정해야한다. 
*/
@Slf4j
public class MemberServiceimpl implements MemberService{
	@Autowired
	MemberRepository repo;
	@Override
	public Long join(Member member) {
		validateDuplicateMember(member);
		// void로 반환하는게 exception으로 밑을 읽지 않고 내려가니까..
		// 그래도. 테이블 자체에서 ID에 유니크 제약 조건을 추가하는 것이 안전 
		log.error("Join=============================================");
		repo.save(member);
		return member.getId();
	}

	@Override
	public void validateDuplicateMember(Member member) {
		log.error("validate=============================================");
		List<Member> findMembers = repo.findByName(member.getName());
		if(!findMembers.isEmpty()){
			throw new IllegalStateException("이미 존재하는 회원입니다.");

		}
	}

	@Override
	public List<Member> findMembers() {
		return repo.findAll();
	}

	@Override
	public Member findOne(Long memberId) {
		return repo.findOne(memberId);
	}
	
}
