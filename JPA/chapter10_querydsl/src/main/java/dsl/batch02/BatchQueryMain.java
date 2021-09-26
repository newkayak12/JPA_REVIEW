package dsl.batch02;
import com.mysema.query.jpa.impl.JPADeleteClause;
import com.mysema.query.jpa.impl.JPAQuery;
import com.mysema.query.jpa.impl.JPAUpdateClause;
import dsl.entity.Item_queryDSL;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import java.util.List;

import static dsl.entity.QItem_queryDSL.item_queryDSL;

public class BatchQueryMain {
/*
    QueryDSL도 수정, 삭제 쿼리와 같은 배치 쿼리를 지원한다.
 */
    static EntityManagerFactory emf = Persistence.createEntityManagerFactory("hibernate");
    static EntityManager em = emf.createEntityManager();
    static EntityTransaction tx = em.getTransaction();
    public static void main(String[] args) {
//        modifyBatch();
        System.out.println("+++");
        deleteBatch();
    }
    public static void modifyBatch(){
//        insert();
        tx.begin();
        JPAUpdateClause updateClause = new JPAUpdateClause(em, item_queryDSL);
        long count = updateClause.where(item_queryDSL.name.eq("mouse")).set(item_queryDSL.price, 9999).execute();
        tx.commit();
        System.out.println("modify : "+count);
//        앞 뒤로 트랜젝션 처리가 필요하다. + set에 값을 집어 넣으면 된다. update price from item_querydsl where name= 'mouse'와 같다.

    }

    public static void deleteBatch(){
        tx.begin();
        JPADeleteClause deleteClause = new JPADeleteClause(em, item_queryDSL);
        long count = deleteClause.where(item_queryDSL.name.eq("mouse")).execute();
        System.out.println("delete : "+ count);
//  count는 적용된 튜플의 수
        tx.commit();
        JPAQuery query = new JPAQuery(em);
        List<Item_queryDSL> list = query.from(item_queryDSL).list(item_queryDSL);
        System.out.println("list : "+list);
    }
}
