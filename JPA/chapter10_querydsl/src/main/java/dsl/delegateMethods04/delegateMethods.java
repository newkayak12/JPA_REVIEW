package dsl.delegateMethods04;

import com.mysema.query.jpa.impl.JPAQuery;
import dsl.entity.Item_queryDSL;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.List;
import static dsl.entity.QItem_queryDSL.item_queryDSL;

public class delegateMethods {
    /*
        메소드 위임을 사용하면 쿼리 타입에 검색 조건을 직접 정의할 수 있다.
     */
    static EntityManagerFactory emf = Persistence.createEntityManagerFactory("hibernate");
    static EntityManager em = emf.createEntityManager();
    static EntityTransaction tx = em.getTransaction();

    public static void main(String[] args) {
        delegateMethod();
    }
    public static void delegateMethod(){
        JPAQuery query = new JPAQuery(em);
        List<Item_queryDSL> list = query.from(item_queryDSL).where(item_queryDSL.isExpensive(20000)).list(item_queryDSL);
        System.out.println(list);
    }
/*
    QUERYDSL은 JPQL보다 sql injection에 덜 취약하다.
    또한 동적 쿼리를 조금 더 쉽게 사용할 수 있게 해준다
 */
}
