package com.jpa.chapter11_web.memberTest;

import javax.transaction.Transactional;

import com.jpa.chapter11_web.Repository.MemberRepository;
import com.jpa.chapter11_web.Repository.MemberRepositoryimpl;
import com.jpa.chapter11_web.Service.MemberService;
import com.jpa.chapter11_web.Service.MemberServiceimpl;
import com.jpa.chapter11_web.domain.Member;

import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
// @Transactional
public class MemberServiceTest {
	@MockBean
	MemberServiceimpl service ;
	@MockBean
	MemberRepositoryimpl repo ;

	@Test
	public void enroll() throws Exception{
		// 주어진 값
		Member member = new Member();
		member.setName("kim");

		//trigger
		Long saveId = service.join(member);


		//match
		Assertions.assertEquals(member, repo.findOne(saveId));
	}
}
