package manyToMany.oneWay;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.List;
import java.util.Locale;

public class OneWayMain {
    static EntityManagerFactory emf = Persistence.createEntityManagerFactory("hibernate");

    public static void main(String[] args) {

        testSave();
        find();
    }
    public static void testSave(){
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();

        tx.begin();
            ProductOneWay productA =new ProductOneWay("productA", "상품A");
            em.persist(productA);

            BuyerOneWay buyer1 = new BuyerOneWay("buyer1", "회원1");
            buyer1.getProducts().add(productA);
            em.persist(buyer1);

        tx.commit();

    }

    public static void find(){
        EntityManager em =emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();

        BuyerOneWay buyerOneWay = em.find(BuyerOneWay.class, "buyer1");
        List<ProductOneWay> products = buyerOneWay.getProducts();

            for(ProductOneWay product : products){
                System.out.println("product : " + product  );
            }

    }

}
