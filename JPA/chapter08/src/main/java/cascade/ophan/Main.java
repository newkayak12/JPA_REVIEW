package cascade.ophan;

import cascade.cascade.Child_Cascade;
import cascade.cascade.Parent_Cascade;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import static cascade.cascade.insert.Main.saveNoCascades;

public class Main {
    static EntityManagerFactory emf = Persistence.createEntityManagerFactory("hibernate08");
    static EntityManager em = emf.createEntityManager();
    static EntityTransaction tx = em.getTransaction();

    public static void main(String[] args) {
        ready();
        orphan();
    }
    public static void ready(){
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

        tx.commit();
        System.out.println("before ::" +parent);
    }
    public static void orphan(){
        tx.begin();
          Parent_Cascade parent = em.find(Parent_Cascade.class, 1L);
            parent.getChildren().remove(0);
        tx.commit();

        System.out.println("after ::" +em.find(Parent_Cascade.class, 1L));
        em.close();

        /*
            참조가 제거된 엔티티는 다른 곳에서 참조하지 않는 객체라는 전제를 두고 삭제한다. 만약 해당 엔티티를 다른 곳에서도 사용한다면 주의가 필요하다
            이런 이유로 orphanRemoval은 @OneToOne, @OneToMany에서만 사용이 가능하다.

            추가적으로 부모가 삭제되면 고아객체들도 삭제되는데 이는 CasacadeType.REMOVE와 같다.
         */
    }
}
