package jpabook.start.entityTemplate;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class EntityTemplate {
    private static EntityManagerFactory emf = Persistence.createEntityManagerFactory("hibernate");
    private static EntityManager em = emf.createEntityManager();
    private static EntityTransaction tx = em.getTransaction();

    public static void transactionBegin(){
        tx.begin();
    }
   public static void transactionCommit(){
        if(tx.isActive()){
            tx.commit();
        }
   }
   public static EntityManager getEntityManager(){
    return em;
   }

}
