package dsl;


import com.mysema.query.jpa.impl.JPAQuery;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.List;

public class QueryDSLMain {
    static EntityManagerFactory emf = Persistence.createEntityManagerFactory("hibernate");
    static EntityManager em = emf.createEntityManager();
    static EntityTransaction tx = em.getTransaction();

    public static void main(String[] args) {

        useQueryDSL();
    }

    public static void useQueryDSL(){
        tx.begin();
        Member_queryDSL m1 = new Member_queryDSL("회원1", Role.ADMIN);
        Member_queryDSL m2 = new Member_queryDSL("회원2", Role.USER);
        Member_queryDSL m3 = new Member_queryDSL("회원3", Role.USER);
        Member_queryDSL m4 = new Member_queryDSL("회원4", Role.USER);
        Member_queryDSL m5 = new Member_queryDSL("회원5",Role.ADMIN);
        em.persist(m1);
        em.persist(m2);
        em.persist(m3);
        em.persist(m4);
        em.persist(m5);
        tx.commit();

        JPAQuery query = new JPAQuery(em);
        QMember_queryDSL qMember_queryDSL = new QMember_queryDSL("m");
////
        List<Member_queryDSL> list= query.from(qMember_queryDSL).orderBy(qMember_queryDSL.name.desc()).list(qMember_queryDSL);
        System.out.println(list);
    }
}
