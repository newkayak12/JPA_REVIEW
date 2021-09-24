package criteria;

import jpql.Member_jpql;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

public class CriteriaMain {
    static EntityManagerFactory emf = Persistence.createEntityManagerFactory("hibernate");
    static EntityManager em = emf.createEntityManager();
    static EntityTransaction tx = em.getTransaction();

    public static void main(String[] args) {
        userCriteria();

    }
    public static void userCriteria(){
        Member_criteria m = new Member_criteria();
        m.setName("kim");

        tx.begin();
        em.persist(m);
        tx.commit();
// Criteria 사용 준비
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Member_criteria> query = cb.createQuery(Member_criteria.class);
// 조회를 시작할 클래스를 잡는 루트 클래스
        Root<Member_criteria> mQuery = query.from(Member_criteria.class);
//  쿼리를 생성
        CriteriaQuery<Member_criteria> criQuery = query.select(mQuery).where(cb.equal(mQuery.get("name"), "kim"));
        List<Member_criteria> mlist = em.createQuery(criQuery).getResultList();
        System.out.println(mlist);
    }

    /*
        Criteria가 가진 장점이 많지만 문제는 굉장히 복잡하다
     */
}
