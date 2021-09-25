package jpql.group;

import javax.persistence.*;
import java.util.List;

public class SetMain {
    static EntityManagerFactory emf = Persistence.createEntityManagerFactory("hibernate");
    static EntityManager em = emf.createEntityManager();
    static EntityTransaction tx = em.getTransaction();

    public static void main(String[] args) {
//    group();
        group2();
    }

    public static void group(){
        Person_set p1 = Person_set.builder().age(18).build();
        Person_set p2 = Person_set.builder().age(19).build();
        Person_set p3 = Person_set.builder().age(21).build();
        Person_set p4 = Person_set.builder().age(23).build();
        Person_set p5 = Person_set.builder().age(27).build();
        Person_set p6 = Person_set.builder().age(29).build();
        Person_set p7 = Person_set.builder().age(30).build();
        Person_set p8 = Person_set.builder().age(15).build();
        Person_set p9 = Person_set.builder().age(22).build();
        Person_set p10 = Person_set.builder().age(42).build();

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


        List<Object[]> result = em.createQuery("SELECT COUNT(p), SUM(p.age), AVG(p.age), MAX(p.age), MIN(p.age) FROM Person_set p").getResultList();

        for(Object[] o : result){
            System.out.println("total : "+o[0]);
            System.out.println("sum : "+o[1]);
            System.out.println("avg : "+o[2]);
            System.out.println("max : "+o[3]);
            System.out.println("min : "+o[4]);

        }
        em.close();
        /*
            1. NULL값은 무시하므로 통계에 잡히지 않는다.(Distinct가 정의되어 있어도 무시된다.)
            2. 만약 값이 없는 집계 함수를 사용하면 NULL값이 된다. count는 0
            3. DISTINCT를 집합 함수 안에 사용해서 중복된 값을 제거하고 나서 집합을 구할 수 있다.
            4. DISTINCT를 count에서 사용할 떄 임베디드 타입은 지원하지 않는다.
         */



    }
    public static void group2(){
        Person_set p1 = Person_set.builder().age(18).build();
        Person_set p2 = Person_set.builder().age(19).build();
        Person_set p3 = Person_set.builder().age(21).build();
        Person_set p4 = Person_set.builder().age(23).build();
        Person_set p5 = Person_set.builder().age(27).build();
        Person_set p6 = Person_set.builder().age(29).build();
        Person_set p7 = Person_set.builder().age(30).build();
        Person_set p8 = Person_set.builder().age(15).build();
        Person_set p9 = Person_set.builder().age(22).build();
        Person_set p10 = Person_set.builder().age(42).build();
        Group_set g1 = new Group_set();
        g1.setTeam("t1");
        Group_set g2 = new Group_set();
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
//
//

        List<Object[]> result = em.createQuery("SELECT g.team, COUNT(m.age), SUM(m.age), AVG(m.age), MAX(m.age), MIN(m.age) from Person_set m LEFT JOIN m.group g  GROUP BY g.team having SUM(m.age) > 118").getResultList();

        for(Object[] o : result){
            System.out.println("team : " +o[0]);
            System.out.println("total : "+o[1]);
            System.out.println("sum : "+o[2]);
            System.out.println("avg : "+o[3]);
            System.out.println("max : "+o[4]);
            System.out.println("min : "+o[5]);

        }
        em.close();
        /*
           Group by 절 = group by {단일값 경로 | 별칭}
           having = Having 조건식
         */



    }
}
