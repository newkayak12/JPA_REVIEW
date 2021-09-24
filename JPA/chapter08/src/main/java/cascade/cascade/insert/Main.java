package cascade.cascade.insert;

import cascade.cascade.Child_Cascade;
import cascade.cascade.Parent_Cascade;

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
        //2번 자식
        Child_Cascade child2 = new Child_Cascade();


        Parent_Cascade parent = new Parent_Cascade();

        child1.setParent(parent);
        child2.setParent(parent);

        parent.getChildren().add(child1);
        parent.getChildren().add(child2);

        em.persist(parent);
        /*
            영속성 전이는 연관된 엔티티도 같이 영속화하는 것에 그치는 것이지 연관관계 매핑과는 관련이 없다.
         */
        tx.commit();
    }

}
