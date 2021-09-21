package manyToMany3;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class ManyToMany3Main {
    static EntityManagerFactory emf = Persistence.createEntityManagerFactory("hibernate");
    static EntityManager em = emf.createEntityManager();
    static EntityTransaction tx = em.getTransaction();

    public static void main(String[] args) {
        save();
        find();
    }

    public static void save(){
        tx.begin();
            Buyer3 b1 = Buyer3.builder().id("buyer1").userName("회원1").build();
            em.persist(b1);

            Product3 p1 = Product3.builder().id("productA").name("상품A").build();
            em.persist(p1);

            Order3 order = Order3.builder().buyer3(b1).product3(p1).orderAmount(2).build();
            em.persist(order);
        tx.commit();

    }

    public static void find(){
        Long orderId = 1L;
        tx.begin();
            Order3 order = em.find(Order3.class, orderId);
            Buyer3 b1 = order.getBuyer3();
            Product3 p1 = order.getProduct3();
        em.close();
        tx.commit();

        System.out.println(order);
        System.out.println(b1);
        System.out.println(p1);
    }

}
