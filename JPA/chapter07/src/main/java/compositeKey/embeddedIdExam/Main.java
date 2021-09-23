package compositeKey.embeddedIdExam;

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
        ParentEmbeddedIdId parentEmbeddedIdId = ParentEmbeddedIdId.builder().id1("myId1").id2("myId2").build();
        ParentEmbeddedId parentEmbeddedId = ParentEmbeddedId.builder().id(parentEmbeddedIdId).name("parentName").build();
        tx.begin();
        em.persist(parentEmbeddedId);
        tx.commit();

        ParentEmbeddedIdId parentEmbeddedIdIdChekcer = ParentEmbeddedIdId.builder().id1("myId1").id2("myId2").build();

        ParentEmbeddedId parent = em.find(ParentEmbeddedId.class,parentEmbeddedIdIdChekcer);

        System.out.println(parent);
        em.close();
    }
}
