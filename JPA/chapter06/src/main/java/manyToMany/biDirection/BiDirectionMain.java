package manyToMany.biDirection;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.List;

public class BiDirectionMain {
    static EntityManagerFactory emf = Persistence.createEntityManagerFactory("hibernate");

    public static void main(String[] args) {

        testSave();
        findInverse();
    }
    public static void testSave(){
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();

        tx.begin();
            ProductBiDirection productA =new ProductBiDirection("productA", "상품A");
            em.persist(productA);

            BuyerBiDirection buyer1 = new BuyerBiDirection("buyer1", "회원1");
            buyer1.addProduct(productA);
            em.persist(buyer1);

        tx.commit();
    }




    public static void findInverse(){
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin();

            ProductBiDirection product  = em.find(ProductBiDirection.class, "productA");
            List<BuyerBiDirection> members = product.getBuyerBiDirections();

            for(BuyerBiDirection b : members){
                System.out.println(b);
            }
    }


}
