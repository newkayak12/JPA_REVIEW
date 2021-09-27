package jpql.entityDirectUsage.namedQuery;

import javax.persistence.*;

public class Main_namedQuery {
    static EntityManagerFactory emf = Persistence.createEntityManagerFactory("hibernate");
    static EntityManager em = emf.createEntityManager();
    static EntityTransaction tx = em.getTransaction();

    public static void main(String[] args) {
    namedQuery();

    }

    public static void namedQuery(){
        tx.begin();
        Friend_namedQuery f1 = Friend_namedQuery.builder().name("yj").birthDay("1996-06-26").phoneNumber("4088-8200").build();
        em.persist(f1);
        tx.commit();
//        Friend_namedQuery friend_namedQuery = em.createNamedQuery("Friend.findByFriendName",Friend_namedQuery.class).setParameter("FriendName", "yj").getSingleResult();
//        System.out.println(friend_namedQuery);

        Query query = em.createNamedQuery("Friend.count");
        Object o = query.getSingleResult();
        System.out.println("named Query : " +o);
// 어노테이션과 XML 중 XML이 우선권을 가진다.

    }
}
