package compositeKey.nonidentifying;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class Main {
    static EntityManagerFactory emf = Persistence.createEntityManagerFactory("hibernate");

    public static void main(String[] args) {
    saveNshow();
    }

    public static void saveNshow(){
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();

        ParentNonIdentifying parent = ParentNonIdentifying.builder().id1("myId1").id2("myId2").name("parentName").build();

        tx.begin();
        em.persist(parent);
        tx.commit();

        ParentNonIdentifyingId parentId = new ParentNonIdentifyingId("myId1","myId2");
        ParentNonIdentifying parents = em.find(ParentNonIdentifying.class, parentId);
        System.out.println(parents);

        em.close();
    }
}
