package com.jpa.chapter11_web.memberTest;



import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.jpa.chapter11_web.Repository.MemberRepositoryimpl;
import com.jpa.chapter11_web.Service.MemberServiceimpl;
import com.jpa.chapter11_web.domain.Member;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit.jupiter.SpringExtension;

// @ExtendWith(SpringExtension.class)
@TestPropertySource("classpath:application.properties")
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
// @RunWith(SpringJUnit4ClassRunner.class)
public class MemberServiceTest {
	@Mock
	MemberRepositoryimpl repo;

	@Test
	@DisplayName("enroll")
	public void enroll() throws Exception{
		// 주어진 값


		String name = "kim";
		final Member member = Member.builder().name(name).build();
		
		//trigger
		repo.save(member);	
		 Member member2 = repo.findOne(1L);

		//match
		Assertions.assertNotNull(member2);
	}	
}
