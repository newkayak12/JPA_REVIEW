package cascade.cascade;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class Main {
    static EntityManagerFactory emf = Persistence.createEntityManagerFactory("hibernate08");
    static EntityManager em = emf.createEntityManager();
    static EntityTransaction tx = em.getTransaction();

    public static void main(String[] args) {
        saveNoCascades();
    }

    public static void saveNoCascades(){

    tx.begin();
        //1번 자식
        Child_Cascade child1 = new Child_Cascade();
        child1.setId(1L);

        //2번 자식
        Child_Cascade child2 = new Child_Cascade();
        child1.setId(2L);


        Parent_Cascade parent = new Parent_Cascade();
        parent.setId(1L);

        child1.setParent(parent);
        child2.setParent(parent);

        parent.getChildren().add(child1);
        parent.getChildren().add(child2);

        em.persist(parent);
        /*
            JPA에서 엔티티를 저장할 떄 연관된 모든 엔티티는 영속 상태여야만 한다.
            따라서 이를 영속성 전이로 전이 시키면 한 번에 영속성 컨텍스트에 맡길 수 있다.
         */
        tx.commit();
    }

}
