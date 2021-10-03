package com.jpa.chapter11_web.memberTest;



import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.TestPropertySource;

import com.jpa.chapter11_web.domain.Member;

// @ExtendWith(SpringExtension.class)
@TestPropertySource("classpath:application.properties")
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
// @RunWith(SpringJUnit4ClassRunner.class)
public class MemberServiceTest {
	@Mock
	com.jpa.chapter11_web.Repository.memberRepository.MemberRepositoryimpl repo;

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
