package dsl;

import com.mysema.query.QueryFactory;
import com.mysema.query.QueryModifiers;
import com.mysema.query.SearchResults;
import com.mysema.query.Tuple;
import com.mysema.query.jpa.JPAExpressions;
import com.mysema.query.jpa.JPASubQuery;
import com.mysema.query.jpa.impl.JPAQuery;
import com.mysema.query.jpa.impl.JPAQueryFactory;
import org.hibernate.jpa.HibernateQuery;

import javax.inject.Provider;
import javax.persistence.*;
import java.util.List;
import static dsl.QMember_queryDSL.member_queryDSL;
import static dsl.QItem_queryDSL.item_queryDSL;
//위의 코드로 아래에서 QMember를 따로 부를 필요가 없어진다.
public class Main {
    static EntityManagerFactory emf = Persistence.createEntityManagerFactory("hibernate");
    static EntityManager em = emf.createEntityManager();
    static EntityTransaction tx = em.getTransaction();

    public static void main(String[] args) {

//        useQueryDSL();
//            conditional();
//                paging();
//                    groupby();
//                        join();
                            subquery();
    }

    public static void insert(){
        Item_queryDSL i1 = Item_queryDSL.builder().name("mouse").price(10000).detail("고급").build();
        Item_queryDSL i2 = Item_queryDSL.builder().name("keyboard").price(12000).detail("저급").build();
        Item_queryDSL i3 = Item_queryDSL.builder().name("printer").price(230000).detail("고급").build();
        Item_queryDSL i4 = Item_queryDSL.builder().name("moniter").price(710000).detail("고급").build();

        tx.begin();
        em.persist(i1);
        em.persist(i2);
        em.persist(i3);
        em.persist(i4);
        tx.commit();
        tx.begin();

        em.persist(Item_queryDSL.builder().name("speaker").price(20000).detail("저급").build());
        em.persist(Item_queryDSL.builder().name("usb").price(4000).detail("저급").build());
        em.persist(Item_queryDSL.builder().name("CPU").price(920000).detail("고급").build());
        em.persist(Item_queryDSL.builder().name("monitor arm").price(22000).detail("저급").build());
        em.persist(Item_queryDSL.builder().name("mouse pad").price(5000).detail("저급").build());
        em.persist(Item_queryDSL.builder().name("fan").price(20000).detail("저급").build());

        em.persist(Member_queryDSL.builder().name("m1").item(i1).role(Role.ADMIN).build());
        em.persist(Member_queryDSL.builder().name("m2").item(i3).role(Role.USER).build());
        tx.commit();
    }

    public static void useQueryDSL(){
        insert();

        JPAQuery query = new JPAQuery(em);
        QMember_queryDSL qMember_queryDSL = new QMember_queryDSL("m");

        List<Member_queryDSL> list= query.from(qMember_queryDSL).where(qMember_queryDSL.role.eq(Role.USER)).orderBy(qMember_queryDSL.name.desc()).list(qMember_queryDSL);
        System.out.println(list);
    }
    public static void conditional(){
        insert();

        JPAQuery query = new JPAQuery(em);
        List<Item_queryDSL> item = query.from(item_queryDSL).where(item_queryDSL.price.lt(240000)).list(item_queryDSL);

        System.out.println(item);

        query = new JPAQuery(em);
//        JPAquery는 쿼리 던지고 바로 close되는 것음 하나로 여러 개 조회가 안되네
//       조건 쿼리
        List<Item_queryDSL> item2 = query.from(item_queryDSL).where(item_queryDSL.detail.contains("고급")).list(item_queryDSL);
//        like %고급%
        query = new JPAQuery(em);
        List<Item_queryDSL> item3 = query.from(item_queryDSL).where(item_queryDSL.detail.startsWith("고")).list(item_queryDSL);
//        like 고%

        System.out.println(item2);
        System.out.println(item3);

        /*
            uniqueResult() : 조회 결과가 한 건일 때 사용한다. 조회 결과가 없으면 null을 반환하고 결과가 하나 이상이면 com.mysema.query.NonUniqueResultException 예외가 발생한다.

            singleResult() : uniqueResult()와 같지만 하나 이상이면 처음 데이터를 반환한다. (많다고 에러가 나는거 아님)

            list() : 결과가 하나 이상 일 때 사용한다. 결과가 없으면 빈 컬렉션을 반환한다.

            >>>>>>>>>>>>>>>>> 3 버전까지는... 4버전은 또 다름

         */
    }

    public static void paging(){
        insert();

//            JPAQuery query = new JPAQuery(em);
//            List<Item_queryDSL> list = query.from(item_queryDSL).orderBy(item_queryDSL.price.desc(), item_queryDSL.name.asc()).offset(0).limit(5).list(item_queryDSL);
//           > offset, limit으로 페이징

//            JPAQuery query = new JPAQuery(em);
//            QueryModifiers queryModifiers = new QueryModifiers(5L,0L);
//            List<Item_queryDSL> list = query.from(item_queryDSL).orderBy(item_queryDSL.price.desc(), item_queryDSL.name.asc()).restrict(queryModifiers).list(item_queryDSL);
//          > queryModifiers로 변형해서 내놓을 수도 있다.


            JPAQuery query = new JPAQuery(em);
            SearchResults<Item_queryDSL> result = query.from(item_queryDSL).orderBy(item_queryDSL.price.desc(), item_queryDSL.name.asc()).offset(0).limit(5).listResults(item_queryDSL);

            long total = result.getTotal();
            long offset = result.getOffset();
            long limit = result.getLimit();
            List<Item_queryDSL> list = result.getResults();
            System.out.println("total : " + total);
            System.out.println("offset : " + offset);
            System.out.println("limit : " + limit);

//        실제 페이징은 listResult()를 사용하여 한다.


            System.out.println(list);
    }

    public static void groupby(){
        insert();

        JPAQuery query = new JPAQuery(em);
        List<Long> list = query.from(item_queryDSL).groupBy(item_queryDSL.detail).having(item_queryDSL.detail.eq("저급")).list(item_queryDSL.price.count());
//      하나면 자료형이고 여러 개면 Tuple로 반환하네
//       원하는 대로 쿼리를 쓸 수가 없네 차라리 JPQL 이 더 편한거 같은데



        System.out.println(list);

    }

    public static void join(){

        insert();
        JPAQuery query = new JPAQuery(em);
        List<Member_queryDSL> list = query.from(member_queryDSL).join(member_queryDSL.item, item_queryDSL).list(member_queryDSL);
        System.out.println(list);

        JPAQuery query2 = new JPAQuery(em);
        List<Member_queryDSL> list2 = query2.from(member_queryDSL).join(member_queryDSL.item, item_queryDSL).on(item_queryDSL.price.gt(1000)).list(member_queryDSL);
        System.out.println(list2);
//        on으로 좁혀서 사용할 수 있다.
    }

    public static void subquery(){
        QItem_queryDSL item = item_queryDSL;
        QItem_queryDSL itemSub = new QItem_queryDSL("itemSub");

        JPAQuery query = new JPAQuery(em);
        List<Item_queryDSL> list = query.from(item).where(item.price.eq(
                new JPASubQuery().from(itemSub).unique(itemSub.price.max())
        )).list(item);
        System.out.println(list);
// 한 건

        JPAQuery query2 = new JPAQuery(em);
        List<Item_queryDSL> list2 = query2.from(item).where(item.in(
                new JPASubQuery().from(itemSub).where(item.name.eq(itemSub.name)).list(itemSub)
        )).list(item);
        System.out.println(list2);
// 여러 건의 결과가 나오는 서브쿼리
    }
}
