package com.jpa.chapter11_web.Repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.jpa.chapter11_web.domain.Member;

import org.springframework.stereotype.Repository;

@Repository
/*
	Repository를 붙이면 JPA전용 예외를 스프링이 추상화한 예외로 변환한다. 예를 들어서 
	javax.persistence.NoresultException이 발생하면
	org.springframework.dao.EmptyResultDataAccessException으로 변환해서 서비스 계층에 반환한다. 
*/
public class MemberRepositoryimpl implements MemberRepository {
	/*
		엔티티 매니저 팩토리에서 엔티티 매니저를 직접 생성해서 사용했지만 스프링을 사용하면 컨테이너가 엔티티 매니저를 관리하고 제공해준다.
		따라서 엔티티 매니저 팩토리에서 엔티티 매니저를 직접 생성해서 사용하는 것이 아니라 컨테이너가 제공하는 엔티티 매니저를 사용해야한다. 
		일종의 DI

		트랜잭션은?? 
		그리고 내가 보기에는 Service계층에서 주입해서 여기로 넘겨주는게 훨씬 좋은 구조 같아 보이는데.. 흠..

		@PersistenceUnit을 통해서 엔티티 매니저 팩토리로 의존성을 주입받을 수 있다. 
	*/
	@PersistenceContext
	EntityManager em;

	@Override
	public void save(Member member) {
		em.persist(member);
		em.flush();
	}

	@Override
	public Member findOne(Long id) {
		return em.find(Member.class, id);
	}

	@Override
	public List<Member> findAll() {
		return em.createQuery("SELECT m FROM Member m", Member.class).getResultList();
	}

	@Override
	public List<Member> findByName(String name) {
		return em.createQuery("SELECT m FROM Member m where m.name = :name", Member.class).setParameter("name", name).getResultList();
	}


	
}
