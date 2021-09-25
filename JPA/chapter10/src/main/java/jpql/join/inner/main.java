package jpql.join.inner;

import jpql.group.Group_set;
import jpql.group.Person_set;

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
        Person_innerJoin p1 = Person_innerJoin.builder().age(18).build();
        Person_innerJoin p2 = Person_innerJoin.builder().age(19).build();
        Person_innerJoin p3 = Person_innerJoin.builder().age(21).build();
        Person_innerJoin p4 = Person_innerJoin.builder().age(23).build();
        Person_innerJoin p5 = Person_innerJoin.builder().age(27).build();
        Person_innerJoin p6 = Person_innerJoin.builder().age(29).build();
        Person_innerJoin p7 = Person_innerJoin.builder().age(30).build();
        Person_innerJoin p8 = Person_innerJoin.builder().age(15).build();
        Person_innerJoin p9 = Person_innerJoin.builder().age(22).build();
        Person_innerJoin p10 = Person_innerJoin.builder().age(42).build();
        Group_innerJoin g1 = new Group_innerJoin();
        g1.setTeam("t1");
        Group_innerJoin g2 = new Group_innerJoin();
        g2.setTeam("t2");
        p1.setGroup(g1);
        p2.setGroup(g2);
        p3.setGroup(g1);
        p4.setGroup(g2);
        p5.setGroup(g1);
        p6.setGroup(g2);
        p7.setGroup(g1);
        p8.setGroup(g2);
        p9.setGroup(g1);
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

        List<Person_innerJoin> person = em.createQuery("SELECT p FROM Person_innerJoin p INNER JOIN p.group g where g.team = :teamName", Person_innerJoin.class).setParameter("teamName", "t1").getResultList();
//        on이 자동으로 채워지네
//      query >>

/*
            Hibernate:
    select
        person_inn0_.person_innerjoin_id as person_i1_9_,
        person_inn0_.age as age2_9_,
        person_inn0_.group_innerjoin_id as group_in3_9_
    from
        person_inner_join person_inn0_
    inner join
        group_inner_join group_inne1_
            on person_inn0_.group_innerjoin_id=group_inne1_.group_innerjoin_id
    where
        group_inne1_.team=?
 */

        System.out.println(person);
    }
}
