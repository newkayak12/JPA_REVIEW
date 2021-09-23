package cascade.vanilla;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class Main {
    static EntityManagerFactory emf = Persistence.createEntityManagerFactory("hibernate08");
    static EntityManager em = emf.createEntityManager();
    static EntityTransaction tx = em.getTransaction();

    public static void main(String[] args) {
        saveNoCascade();
    }
    public static void saveNoCascade(){
        tx.begin();

        Parent_Vanilla parent = new Parent_Vanilla();
        parent.setId(1L);
        em.persist(parent);

        //1번 자식
        Child_Vanilla child1 = new Child_Vanilla();
        child1.setId(1L);
        child1.setParent(parent);
        parent.getChildren().add(child1);
        em.persist(child1);

        //2번 자식
        Child_Vanilla child2 = new Child_Vanilla();
        child2.setParent(parent);
        parent.getChildren().add(child2);
        child1.setId(2L);
        em.persist(child2);

        /*
            JPA에서 엔티티를 저장할 떄 연관된 모든 엔티티는 영속 상태여야만 한다.
            따라서 이를 영속성 전이로 전이 시키면 한 번에 영속성 컨텍스트에 맡길 수 있다.
         */
    }

}
