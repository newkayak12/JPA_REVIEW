package compositeKey.idClassExam;

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

        ParentIdClass parent = ParentIdClass.builder().id1("myId1").id2("myId2").name("parentName").build();

        tx.begin();
        em.persist(parent);
        tx.commit();

        ParentIdClassId parentId = new ParentIdClassId("myId1","myId2");
        ParentIdClass parents = em.find(ParentIdClass.class, parentId);
        System.out.println(parents);

        em.close();
    }
}
