package queryDSL;

import com.querydsl.jpa.impl.JPAQuery;
import jpql.Member_jpql;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.lang.reflect.Member;
import java.util.List;

public class QueryDSLMain {
    static EntityManagerFactory emf = Persistence.createEntityManagerFactory("hibernate");
    static EntityManager em = emf.createEntityManager();
    static EntityTransaction tx = em.getTransaction();

    public static void main(String[] args) {
    useQueryDSL();
    }
    public static void useQueryDSL(){
        Member_queryDSL m = new Member_queryDSL();
        m.setName("kim");

        tx.begin();
        em.persist(m);
        tx.commit();
        JPAQuery query  = new JPAQuery(em);
//        List<Member_queryDSL> mlist = query.from(member).from()
    }
}
