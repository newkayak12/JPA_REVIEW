package jpql;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.lang.reflect.Member;
import java.util.List;

public class JpqlMain {
    static EntityManagerFactory emf = Persistence.createEntityManagerFactory("hibernate");
    static EntityManager em = emf.createEntityManager();
    static EntityTransaction tx = em.getTransaction();

    public static void main(String[] args) {
    useJpql();
    }
    public static void useJpql(){
        Member_jpql m = new Member_jpql();
        m.setName("kim");

        tx.begin();
        em.persist(m);
        tx.commit();

        String jpql = "select m from MEMBER_JPQL as m where m.name = 'kim'";
//        엔티티 대상이므로 엔티티의 필드명이 들어가야한다. (where 뒤에)
        List<Member_jpql> ms = em.createQuery(jpql, Member_jpql.class).getResultList();
        System.out.println(ms);
    }
}
