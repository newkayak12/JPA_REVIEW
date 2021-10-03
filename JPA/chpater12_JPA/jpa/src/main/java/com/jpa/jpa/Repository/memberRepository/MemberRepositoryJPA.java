package com.jpa.jpa.Repository.memberRepository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jpa.jpa.domain.Member;

public interface MemberRepositoryJPA extends JpaRepository<Member, Long> {
//	JpaRepository를 상속 받는다. 
	/*
	 * ----------스프링 데이터 --------------
	 * 		<<interface>> repository
	 * 			
	 * 			[상속]
	 * 
	 * 		<<interface>> crudRepository
	 * 			
	 * 			[상속]
	 * 
	 * 		<<interface>> PagingAndSortingRepository
	 * 			
	 * 			[상속]
	 * 
	 * ------------스프링 JPA --------------
	 * 		<<interface>> JpaRepository
	 * 		
	 * 
	 *			save(s) : 새로운 엔티티를 저장하고 이미 있는 엔티티는 수정한다. ( 식별자 값이 없으면 새로운 엔티티로 판단해서 EntityManager.persist()를 식별자 값이 있으면 이미 있는 엔티티로 판단해서 EntityManger.merge()를 호출한다. )
	 			delete(T) : 엔티티 하나를 삭제한다  내부에서 EntityManager.remove()를 호출한다.
				findOne(ID) : 엔티티 하난를 조회한다. 내부에서 EntityManager.find()를 호출한다.
				getOne(Id) : 엔티티를 프록시로 조회한다. 내부에서 EntityManger.getReference()(PK만 가지고 있는 프록시 객체) 를 호출한다.
				findAll(...) : 모든 엔티티를 조회한다. 정렬이나 페이징 조건을 파라미터로 제공할 수 있다. 
	 * 
	 * 
	 */


	 /*
			쿼리 메소드 기능 
			>> 인터페이스에 메소드만 선언하면 해당 메소드의 이름으로 적절한 JPQL쿼리를 생성해서 실행한다.

			1. 메소드 이름으로 쿼리 생성
			2. 메소드 이름으로 JPA NamedQuery 호출
			3. @Query 어노테이션을 사용해서 리포지토리 인터페이스에 쿼리 직접 정의




			1. 메소드 이름으로 쿼리 생성
				이메일과 이름으로 회원을 조회하려면 다음과 같은 메소드를 정의하면 된다. 
				
				public interface MemberRepository extends Repository<Member, Long>{
					List<Member> findByEmailAndName(String email, String name)
				}

				이렇게 지정하면 JPA는 메소드 이름을 분석해서 JPQL을 생성하고 실행한다. 실행한  JPQL은
				
				select m from Member m where m.email = ?1 and m.name = ?2

				>> 물론! 정해진 규칙에 따라서 메소드 이름을 지어야 한다. 

				And > findByLastNameAndFirstName
				Or > findByLastNameOrFirstName
				is,Equal > findbyFirstname(findbyFirstnameIs) / findbyFirstnameEquals
				LessThan > findByAgeLessthan
				LessThanEqual > findByAgeLessThanEqual
				GreaterThan > findByAgeGreaterThan
				GreaterThanEqual > findByAgeGreaterThanEqual

				after > findByStartAfter
				before > findByStartBefore
				isNull > findByAgeIsNull
				isNotNull, NotNull > findByAge(is)NotNull
				Like > findByNameLike
				NotLike > findByNameNotLike
			
				StartingWith > findByNameStartingWith
				EndingWith > findByNameEndWith
				Containing > findByNameContaining
				OrderBy > findByAgeOrderByLastNameDesc

				Not > findByNameNot
				In > findByAgeIn(Collection ages)
				NotIN> findByAgeNotin(Collection ages)
				TRUE > findByActiveTrue()
				FALSE > findByActiveFalse()
				IgnoreCase > findByNameIgnoreCase


			2.JPA NameqQuery : 메소드 이름으로 JPA NamedQuery를 호출하는 기능을 제공한다.
				예를 들어
				
					@Entity
					@NamedQuery(
						name="Member.findByUserName",
						query="select m from Member m where m.userName = :userName"
					)
					public class Member{
						...
					}

				와 같이 되어 있다면 혹은 xml에서

					<named-query name="Member.findByUserName">
						<query>

						<![CDATA[

							select m 
							from Member m
							where m.userName = :userName

						]]>

						</query>
					</named-query>
					

					
				원래는 JPA에서

					em.createNamedQuery("Member.findByUserName", Member.class).setParameter("userName","parameter").getResultList();

				와 같이 해야 했는데, JPA로 nameQuery를 호출하면

					List<Member> findByUserName(@Param("userName") String userName);
				
				와 같이 설정하면 Named쿼리를 실행한다. 만약 Named쿼리가 없다면 위의 이름으로 1번의 쿼리 생성 전략을 사용한다. 


			3. @Query, 레포지토리 메소드에 쿼리 정의
				Repository 메소드에 직접 쿼리를 정의하려면 @org.springframeword.data.jpa.repository.Query 어노테이션을 사용한다. 인터페이스에

					- JPQL -

					@Query("select m from Member m where m.username = ?1")
					Member findByUserName(String userName);

					- Native -

					@Query(value="SELECT * FORM MEMBER WHERE USERNAME = ?0", nativeQuery = true)
					Member findByUserName(String userName);


				파라미터는 
						1. 위치 기반	m.userName = ?1
						2. 이름 기반  	m.userNmae = :name
				으로 할 수 있다. 


				
	 */
}
