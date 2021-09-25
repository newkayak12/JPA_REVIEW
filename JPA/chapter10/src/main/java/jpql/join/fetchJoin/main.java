package jpql.join.fetchJoin;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.List;

public class main {
    static EntityManagerFactory emf = Persistence.createEntityManagerFactory("hibernate");
    static EntityManager em = emf.createEntityManager();
    static EntityTransaction tx = em.getTransaction();


    public static void main(String[] args) {
    join();
    }

    public static void join(){
        Person_fetchJoin p1 = Person_fetchJoin.builder().age(18).build();
        Person_fetchJoin p2 = Person_fetchJoin.builder().age(19).build();
        Person_fetchJoin p3 = Person_fetchJoin.builder().age(21).build();
        Person_fetchJoin p4 = Person_fetchJoin.builder().age(23).build();
        Person_fetchJoin p5 = Person_fetchJoin.builder().age(27).build();
        Person_fetchJoin p6 = Person_fetchJoin.builder().age(29).build();
        Person_fetchJoin p7 = Person_fetchJoin.builder().age(30).build();
        Person_fetchJoin p8 = Person_fetchJoin.builder().age(15).build();
        Person_fetchJoin p9 = Person_fetchJoin.builder().age(22).build();
        Person_fetchJoin p10 = Person_fetchJoin.builder().age(42).build();
        Group_fetchJoin g1 = new Group_fetchJoin();
        g1.setTeam("t1");
        Group_fetchJoin g2 = new Group_fetchJoin();
        g2.setTeam("t2");
        p1.addGroup(g1);
        p2.addGroup(g1);
        p3.addGroup(g1);
        p4.addGroup(g1);
        p5.addGroup(g1);
        p6.addGroup(g2);
        p7.addGroup(g2);
        p8.addGroup(g2);
        p9.addGroup(g2);
        p10.addGroup(g2);


        tx.begin();
        em.persist(g1);
        em.persist(g2);
        em.persist(p1);
        em.persist(p2);
        em.persist(p3);
        em.persist(p4);
        em.persist(p5);
        em.persist(p6);
        em.persist(p7);
        em.persist(p8);
        em.persist(p9);
        em.persist(p10);
        tx.commit();

        List<Person_fetchJoin> person = em.createQuery("SELECT p FROM Person_fetchJoin p JOIN FETCH p.group").getResultList();
// fetch join  시에는  지연로딩이 발생하지 않는다.
        List<Group_fetchJoin> g = em.createQuery("SELECT distinct g FROM Group_fetchJoin g join FETCH g.persons where g.team = :teamName",Group_fetchJoin.class).setParameter("teamName","t1").getResultList();
// 컬렉션 페치를 하면 같은 값이 여러 개 나올 수 있다. 그리하여 DISTINCT로 중복결과를 제거한다.
        System.out.println("person " +person);
        for(Group_fetchJoin gs : g){
            System.out.println(gs);
        }
    }
}

/*
    페치 조인과 일반 조인의 차이
    일반 조인은 SELECT에 따로 명시하지 않으면 같이 딸려오는 것을 조회하지 않지만
    페치 조인은 한 번에 다 같이 가져온다.

    페치 조인을 하면 SQL한 번으로 연관된 엔티티들을 함께 조회할 수 있어서 SQL호출 횟수를 줄여서 성능을 최적화할 수 있다.

    최적화를 위해 글로벌 로딩 전략을 EAGER로 설정하면 지속적으로 로딩이 발생할 수 있다. 이는 일부는 빠를지 몰라도 전체 성능의 저하를 초래할 수 있다.
    따라서 지연로딩을 사용하고 최적화가 필요한 곳에서 페치 조인을 쓰는 것이 낫다.

    한계점
        - 페치 조인은 별칭을 정의하지 않아서 SELECT, WHERE, 서브쿼리에 페치 조인 대상을 적용할 수 없다.
        - 둘 이상의 컬렉션을 페치할 수 없다. (구현체에 따라 되기도 하지만 컬렉션 간의 카테시안 곱이 만들어진다. > 하이버네이트에서는 javax.persistence.PersistenceExcpetion : org.hibernate.loader.MultipleBagFetchExcpetion : cannot simultaneously fetch multiple bags 예외가 발생한다.
        - 컬렉션을 페치 조인하면 페이징을 사용할 수 없다.
            > 컬렉션(1:N)이 아닌 단일 값 연관 필드(1:1 // N:1)들은 페치 조인을 사용해도 페이징 API를 사용할 수 있다.
            > 하이버네이트에서 컬렉션 페치 조인하고 페이징 API를 사용하면 메모리에서 페이징 처리를 한다. 데이터 적으면 상관이 없지만 데이터가 많으면 메모리 초과가 생길 수 있다.


  >> 만약 엔티티 그대로 불러서 쓴다면 상관없지만 두 개의 엔티티로 변형하여 새로운 결과값을 만들어 DTO로 사용한다면 JOIN하는 것이 낫다.
 */

