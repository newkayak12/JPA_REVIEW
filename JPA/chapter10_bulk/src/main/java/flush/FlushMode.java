package flush;

import entity.Item_bulk;

import javax.persistence.*;

import static bulk.BulkMain.insert;
public class FlushMode {
    static EntityManagerFactory emf = Persistence.createEntityManagerFactory("hibernate");
    static EntityManager em = emf.createEntityManager();
    static EntityTransaction tx = em.getTransaction();

    public static void main(String[] args) {
//        flushTest();
        flushMode();
    }
    public static void flushTest(){
        insert();
    Item_bulk item =  em.find(Item_bulk.class, 1L);
        System.out.println("original : "+item);
    item.setItemBulkPrice(3000);
        System.out.println("set price 3000 : "+item);

    Item_bulk itemJPQL = em.createQuery("SELECT i FROM Item_bulk i WHERE i.itemBulkPrice =:itemBulkPrice", Item_bulk.class).setParameter("itemBulkPrice", 3000).getSingleResult();
        System.out.println("JQPL : "+itemJPQL);
        /*
            Exception in thread "main" javax.persistence.NoResultException: No entity found for query
            at org.hibernate.jpa.internal.QueryImpl.getSingleResult(QueryImpl.java:498)
            at flush.FlushMode.flushTest(FlushMode.java:25)
            at flush.FlushMode.main(FlushMode.java:16)

            결과 값이 없다. >> 가격이 3000인 컬럼이 없기 때문
         */

    }
    public static void flushMode(){
        em.setFlushMode(FlushModeType.COMMIT);
        insert();
        Item_bulk item =  em.find(Item_bulk.class, 1L);
        System.out.println("original : "+item);

        tx.begin();
        item.setItemBulkPrice(3000);
        System.out.println("set price 3000 : "+item);

        //플러시를 강제로 해준다.
//        em.flush();
        tx.commit();

        Item_bulk itemJPQL = em.createQuery("SELECT i FROM Item_bulk i WHERE i.itemBulkPrice =:itemBulkPrice", Item_bulk.class).setParameter("itemBulkPrice", 3000).setFlushMode(FlushModeType.AUTO).getSingleResult();
        //이렇게 쿼리에 플러시 모드를 주면 글로벌 플러시 정책보다 우선한다.
        System.out.println("JQPL : "+itemJPQL);

//        플러시로 영속성 컨텍스트로 DB와 동기화를 했다. 덕분에 가격이 3000인 컬럼을 찾아냈다.

    }
    /*
          FlushModeType.COMMIT은 트랜잭션이 커밋할 때만 플러시하고 쿼리를 실행할 때는 플러시하지 않는다. 이는 DB에 반영하지 않아서 무결성에 심각한 피해를 줄 수 있지만
          등록()
          쿼리() /플러시
          등록()
          쿼리() /플러시
          등록()
          쿼리() /플러시
          커밋() /플러시
          이렇게 되면 AUTO에서는 4 번의 플러시가 나지만
          COMMIT 에서는 1번의 플러시로 최적화를 할 수 있다.

          또, JDBC 등을 따로 사용 할때 flush 를 호출해서 영속성 컨텍스트의 내용을 DB에 동기화하는 것이 안전하다.
     */

    /*
        정리
        JPQL은 SQL을 추상화해서 특정 DB 기술에 의존하지 않는다.
        Criteria, QueryDSL 은 JPQL을 만들어주는 빌더 역할을 할 뿐이므로 핵심은 JPQL을 잘 알아야 한다.
        Criteria, QueryDSL를 사용하면 동적 쿼리를 편하게 작성할 수 있다.
        Criteria는 JPA공식 지원 기능이지미나 복잡하며, 이러한 점을 보완하기 위해서 QueryDSL을 사용한다.
        JPA도 Native SQL을 제공하여 사용할 수 있지만 DB에 종속적인  SQL을 사용하면 다른  DB로 변경하기 쉽지 않다. 따라서 최대한 JPQL을 이용하고, 방법이 없을 떄 Native쿼리르 사용하는 것이 좋다.
        JPQL은 대량의 데이터를 수정하거나 삭제하는 벌크 연산을 지원한다. 하지만 이는 영속성 컨텍스트에서 직접 관리하지 않으므로 무결성 이슈가 생길 수 있다.

     */

}
