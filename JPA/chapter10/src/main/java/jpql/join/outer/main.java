package jpql.join.outer;

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
        Person_outerJoin p1 = Person_outerJoin.builder().age(18).build();
        Person_outerJoin p2 = Person_outerJoin.builder().age(18).build();
        Person_outerJoin p3 = Person_outerJoin.builder().age(18).build();
        Person_outerJoin p4 = Person_outerJoin.builder().age(18).build();
        Person_outerJoin p5 = Person_outerJoin.builder().age(18).build();
        Person_outerJoin p6 = Person_outerJoin.builder().age(29).build();
        Person_outerJoin p7 = Person_outerJoin.builder().age(30).build();
        Person_outerJoin p8 = Person_outerJoin.builder().age(15).build();
        Person_outerJoin p9 = Person_outerJoin.builder().age(22).build();
        Person_outerJoin p10 = Person_outerJoin.builder().age(42).build();
        Group_outerJoin g1 = new Group_outerJoin();
        g1.setTeam("t1");
        Group_outerJoin g2 = new Group_outerJoin();
        g2.setTeam("t2");
        p1.setGroup(g1);
        p3.setGroup(g1);
        p5.setGroup(g1);

        p6.setGroup(g2);
        p7.setGroup(g2);
        p8.setGroup(g2);
        p9.setGroup(g2);
        p10.setGroup(g2);


        tx.begin();
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

        List<Person_outerJoin> person = em.createQuery("SELECT p FROM Person_outerJoin p left JOIN p.group g where p.age = :age", Person_outerJoin.class).setParameter("age",18).getResultList();
//        on이 자동으로 채워지네
        /*
            >> on 절을 사용하면 조인 대상을 필터링하고 조인할 수 있다. 내부 조인의 on 절은 where절을 사용할 떄와 결과가 같으므로 보퉁 on 절은 외부 조인에서만 사용한다.
         */

//      query >>

/*
    Hibernate:
    select
        person_out0_.person_innerjoin_id as person_i1_11_,
        person_out0_.age as age2_11_,
        person_out0_.group_innerjoin_id as group_in3_11_
    from
        person_outer_join person_out0_
    left outer join
        group_outer_join group_oute1_
            on person_out0_.group_innerjoin_id=group_oute1_.group_innerjoin_id
    where
        person_out0_.age=?
*/
        System.out.println(person);
    }
}
