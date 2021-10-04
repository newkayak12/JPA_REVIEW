package listener.toEntity;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class ToEntityMain {
    static EntityManagerFactory emf = Persistence.createEntityManagerFactory("hibernate");
    static EntityManager em = emf.createEntityManager();
    static EntityTransaction tx = em.getTransaction();

    public static void main(String[] args) {
        toEntity();
    }
    public static void toEntity(){
        Duck duck = new Duck();
        tx.begin();
            em.persist(duck);
        tx.commit();
        /*
            Duck.prePersist id=null
            Hibernate:
                call next value for hibernate_sequence
            Hibernate:
                insert
                into
                    duck
                    (id)
                values
                    (?)
            Duck.postPersist id=1
         */
    }

}
