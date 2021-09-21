package oneToMany_oneWay;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class OneToManyMain {
    static EntityManagerFactory emf = Persistence.createEntityManagerFactory("hibernate");
    public static void main(String[] args) {
        testSave();

    }
    public static void testSave(){
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx  = em.getTransaction();
        MemberOneToMany m1 = new MemberOneToMany("member1");
        MemberOneToMany m2 = new MemberOneToMany("member2");

        TeamOneToMany t1 = new TeamOneToMany("team1");
        t1.getMembers().add(m1);
        t1.getMembers().add(m2);

        tx.begin();

            em.persist(m1);
            em.persist(m2);
            em.persist(t1);

        tx.commit();
//MemberEntity는 TeamEntity를 모른다.


    }
}
