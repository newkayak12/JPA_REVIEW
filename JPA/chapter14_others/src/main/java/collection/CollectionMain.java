package collection;

import collection.entity.Team;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
public class CollectionMain {
	static EntityManagerFactory emf = Persistence.createEntityManagerFactory("hibernate");
	static EntityManager em = emf.createEntityManager();
	static EntityTransaction tx = em.getTransaction();

	public static void main(String[] args) {
		collection();
	}

	public static void collection(){
		Team team = new Team();
		System.out.println("before persist = " + team.getMembers().getClass());
		em.persist(team);
		System.out.println("after persist = " + team.getMembers().getClass());
		/*
			before persist = class java.util.ArrayList
			after persist = class org.hibernate.collection.internal.PersistentBag

			하이버네이트는 컬렉션을 효율적으로 관리하기 위해 엔티티를 영속 상태로 만들 떄 원본 컬렉션을 감싸고 있는 내장 컬렉션을 생성해서 이 내장 컬렉션을 사용하도록 참조를 변경한다.
			따라서 이런 특징이 있기 때문에 컬렉션을 사용할 때 즉시 초기화하는 것을 권장한다.
			Collection<Member> members = new ArrayList<Member>;


		 */

		System.out.println("COLLECTION : "+team.getMembers().getClass());
		System.out.println("List : "+team.getMembersList().getClass());
		System.out.println("Set : "+team.getSet().getClass());
		System.out.println("List(@OrderColumn) : "+team.getMemberOrderList().getClass());

		/*
			COLLECTION : class org.hibernate.collection.internal.PersistentBag
			List : class org.hibernate.collection.internal.PersistentBag
			Set : class org.hibernate.collection.internal.PersistentSet
			List(@OrderColumn) : class org.hibernate.collection.internal.PersistentList
		 */

		/*							내장 컬렉션		중복 허용 	순서 보관
			COLLECTION, LIST		PersistentBag	   O			X
			Set						PersistentSet	   X			X
			List+@OrderColumn		PersistentList	   O			O


			COLLECTION, List는 중복을 허용하는 컬렉션이고 객체를 추가할 때 내부 비교 없이 추가된다. 삭제는 equals() 메소드를 사용한다. (중복 검사를 하지 않으므로 엔티티를 추가해도 지연 로딩된 컬렉션을 초기화 하지 않는다.)
			Set은 중복을 허용하지 않는 컬렉션이다. 따라서 add로 추가할 때 내부 비교를 한 후 추가한다. Hash알고리즘을 사용하므로 hashcode()도 함께 사용한다. (추가할 떄 중복검사를 위해 지연 로딩된 컬렉션을 초기화한다.)
			List + @OrderColumn : 데이터베이스에 순서 값을 저장해서 조회할 때 사용한다. (순서가 있는 컬렉션은 DB에 그 순서도 함께 저장되어 관리된다. )


		 */
	}
}
