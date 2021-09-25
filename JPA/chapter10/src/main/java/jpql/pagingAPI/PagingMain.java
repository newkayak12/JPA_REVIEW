package jpql.pagingAPI;

import javax.persistence.*;
import java.util.List;

public class PagingMain {
    static EntityManagerFactory emf = Persistence.createEntityManagerFactory("hibernate");
    static EntityManager em = emf.createEntityManager();
    static EntityTransaction tx = em.getTransaction();

    public static void main(String[] args) {
        paging();
    }
    public static void paging(){
        JpqlPagingTest p1 = JpqlPagingTest.builder().title("t1").content("c1").build();
        JpqlPagingTest p2 = JpqlPagingTest.builder().title("t2").content("c2").build();
        JpqlPagingTest p3 = JpqlPagingTest.builder().title("t3").content("c3").build();
        JpqlPagingTest p4 = JpqlPagingTest.builder().title("t4").content("c4").build();
        JpqlPagingTest p5 = JpqlPagingTest.builder().title("t5").content("c5").build();
        JpqlPagingTest p6 = JpqlPagingTest.builder().title("t6").content("c6").build();
        JpqlPagingTest p7 = JpqlPagingTest.builder().title("t7").content("c7").build();
        JpqlPagingTest p8 = JpqlPagingTest.builder().title("t8").content("c8").build();
        JpqlPagingTest p9 = JpqlPagingTest.builder().title("t9").content("c9").build();
        JpqlPagingTest p10 = JpqlPagingTest.builder().title("t10").content("c10").build();
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

        TypedQuery<JpqlPagingDTO> query = em.createQuery("SELECT new jpql.pagingAPI.JpqlPagingDTO (p.id, p.title, p.content) FROM JpqlPagingTest p ORDER BY p.id DESC", JpqlPagingDTO.class);

        query.setFirstResult(0);
        query.setMaxResults(5);
//        여기도 시작점은 0이다.

        List<JpqlPagingDTO> result = query.getResultList();

        System.out.println("0:5  _ "+result);

        query.setFirstResult(5);
        query.setMaxResults(5);

        List<JpqlPagingDTO> result2 = query.getResultList();

        System.out.println("5:5  _ "+result2);

        em.close();
    }
//   mybatis rowBounds와 비슷하게 굉장히 간단하다.
//    단, 최적화를 해야한다면 네이티브로 구성하는 것이 나을 수도 있다.
}
