package com.jpa.chapter11_web.memberTest;


import static org.junit.jupiter.api.Assertions.fail;

import java.util.List;

import javax.transaction.Transactional;

import com.jpa.chapter11_web.Repository.MemberRepositoryimpl;
import com.jpa.chapter11_web.Service.MemberServiceimpl;
import com.jpa.chapter11_web.domain.Member;

import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.junit4.SpringRunner;

// @RunWith(SpringRunner.class)
@Transactional
@TestPropertySource("classpath:application.properties")
// @ExtendWith(SpringExtension.class)
@RunWith(SpringRunner.class)
@DataJpaTest
public class MemberServiceTest {
	@Mock
	MemberServiceimpl service;
	@MockBean
	MemberRepositoryimpl repo;

	@Test
	public void enroll() throws Exception{
		// 주어진 값
		Member member = new Member();
		String name = "kim";
		member.setName(name);

		//trigger
		repo.save(member);
		List<Member> mem = repo.findByName(name);


		//match
		Assertions.assertEquals(1, mem.size());
	}
}
