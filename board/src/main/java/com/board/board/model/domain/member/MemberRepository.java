package com.board.board.model.domain.member;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface MemberRepository extends JpaRepository<Member,String> {
	@Query(value = "SELECT count(*) FROM member m WHERE m.user_id =:userId and m.user_password= :userPassword ", nativeQuery = true) 
	int login(@Param("userId") String userId, @Param("userPassword") String userPassword);
	
}