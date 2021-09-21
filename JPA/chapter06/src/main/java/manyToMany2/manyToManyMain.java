package manyToMany2;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.Date;

public class manyToManyMain {
    static EntityManagerFactory emf = Persistence.createEntityManagerFactory("hibernate");
    public static void main(String[] args) {
        save();
        find();
    }
    public static void save(){
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();

        tx.begin();
        Buyer2 b1 =  Buyer2.builder().id("buyer1").userName("회원1").build();
        em.persist(b1);

        Product2 pA = Product2.builder().id("productA").name("상품A").build();
        em.persist(pA);

        BuyerProduct2 bp1 = new BuyerProduct2();
        bp1.setBuyer2(b1);
        bp1.setProduct2(pA);
        bp1.setOrderAmount(2);
        bp1.setOrderDate(new Date());

        em.persist(bp1);

        tx.commit();
    }

    public static void find(){
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();

        tx.begin();

        BuyerProduct2ID bp2id = new BuyerProduct2ID();
        bp2id.setBuyer2("buyer1");
        bp2id.setProduct2("productA");

        BuyerProduct2 bp2 = em.find(BuyerProduct2.class, bp2id);

        Buyer2 b1 = bp2.getBuyer2();
        Product2 p1 = bp2.getProduct2();

        System.out.println(b1);
        System.out.println(p1);
        System.out.println(bp2.getOrderAmount());
        System.out.println(bp2.getOrderDate());

        tx.commit();
        em.close();

    }


}
