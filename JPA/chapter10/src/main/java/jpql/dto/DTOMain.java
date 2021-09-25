package jpql.dto;

import jpql.entity.Address_jpql;
import jpql.entity.Member_jpql2;
import jpql.entity.Order_jpql;
import jpql.entity.Product_jpql;

import javax.persistence.*;
import java.util.Iterator;
import java.util.List;

public class DTOMain {
    static EntityManagerFactory emf = Persistence.createEntityManagerFactory("hibernate");
    static EntityManager em = emf.createEntityManager();
    static EntityTransaction tx = em.getTransaction();

    public static void main(String[] args) {
//    show();
//        scalar();
            multiEntity();
    }
    public static void show(){
        Order_jpql o = new Order_jpql();
        o.setOrderAmount(1);
        Address_jpql add = new Address_jpql();
        add.setCity("seoul");
        add.setStreet("taehae");
        add.setZipcode("123123");
        o.setAddress(add);

        tx.begin();
        em.persist(o);
        tx.commit();


        String query = "SELECT a FROM ADDRESS a";
//      임베디드 타입은 조회의 시작이 될 수 없다. 따라서 위의 것이 아니고
        query = "SELECT o.address FROM Order_jpql o";
        List<Address_jpql> addresses = em.createQuery(query, Address_jpql.class).getResultList();
        System.out.println(addresses);
        //이렇게 조회된 임베디드 타입은 엔티티 타입이 아닌 값 타입이기 떄문에 영속성 컨텍스트에서 관리되지 않는다.

    }
/*
    스칼라 타입 프로젝션 : 기본 자료형을 스칼라 타입이라고 한다.
 */
    public static void scalar(){
//        Member_jpql2 m1 = new Member_jpql2();
//        m1.setName("m1");
//        Member_jpql2 m2 = new Member_jpql2();
//        m2.setName("m2");
//        Member_jpql2 m3 = new Member_jpql2();
//        m3.setName("m3");
//        tx.begin();
//        em.persist(m1);
//        em.persist(m2);
//        em.persist(m3);
//        tx.commit();

        String jpql = "SELECT DISTINCT name FROM MEMBER_JPQL2 m";

        List<String> usernames = em.createQuery(jpql, String.class).getResultList();
        System.out.println(usernames);

//        > 여러 값 조회할 때는 엔티티를 대상으로 조회하면 편리하겠지만 꼭 필요한 데이터만 선별해서 조회해야할 때도 있다. 이 떄는 Query를 사용해야한다.


        Query query = em.createQuery(jpql);
        List resultList = query.getResultList();
        Iterator iterator = resultList.iterator();
        while(iterator.hasNext()){
            String userName =(String) iterator.next();
//            원래는 Object[]로 받아서 형변환을 했지만 다른 컬럼이 없는 관계로 이렇게 했다.
            /*
                위의 둘을 섞으면
                List<Object[]> resultList = em.createQuery(jpql).getResultList();

                for(Object[] row : resultList){
                    String userName = (String) row[0]
                    Integer age = (Integer) row[1]
                }

                이런식이다.
             */
            System.out.println(userName);
        }
    }

    public static void multiEntity(){
        Order_jpql o = new Order_jpql();
        Address_jpql a = new Address_jpql();
        a.setZipcode("123");
        a.setStreet("gil");
        a.setCity("city");

        Product_jpql p = new Product_jpql();
        p.setName("p1");
        p.setPrice(100);
        p.setStockAmount(2);

        Member_jpql2 m = new Member_jpql2();
        m.setName("m1");

        o.setAddress(a);
        o.setProduct(p);
        o.setMember(m);
        tx.begin();
        em.persist(o);
        tx.commit();

//        List<Object[]> resultList = em.createQuery("SELECT o.member, o.product, o.address FROM Order_jpql o").getResultList();
//        System.out.println(resultList.size()+"sss");
//        Order_dto_jpql oDto = new Order_dto_jpql();
////        객체 변환 작업
//        for(Object[] row : resultList){
//            o.setMember((Member_jpql2) row[0]);
//            o.setProduct((Product_jpql) row[1]);
//            o.setAddress((Address_jpql) row[2]);
//            System.out.println(oDto.getAddress() +":"+ oDto.getMember() +":"+ oDto.getProduct());
// 위와 같이 DTO를 이용해서 받을 수 있다.
//        이런 객체 변환 작업을 줄일 수 있는 방법이 있는데, jpql에 new명령어를 쓰는 것이다.

        TypedQuery<Order_dto_jpql> query  = em.createQuery("SELECT new jpql.dto.Order_dto_jpql(o.member, o.product, o.address) FROM Order_jpql o", Order_dto_jpql.class);
        /*
            1. 패키지 명을 포함한 전체 클래스 명을 입력해야한다.
            2. 순서와 타입이 일치하는 생성자가 필요하다.
         */
        List<Order_dto_jpql> orderDto = query.getResultList();

        System.out.println(orderDto);

        // 단 생성자로 초기화하기 때문에 뽑아내는 것에 맞춰서 생성자를 작성해줘야한다.
    }




}

