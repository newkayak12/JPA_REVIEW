package cascade.cascade.delete;

import cascade.cascade.Child_Cascade;
import cascade.cascade.Parent_Cascade;
import org.hibernate.annotations.Parent;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import static cascade.cascade.insert.Main.saveNoCascades;

public class main {
    static EntityManagerFactory emf = Persistence.createEntityManagerFactory("hibernate08");
    static EntityManager em = emf.createEntityManager();
    static EntityTransaction tx = em.getTransaction();

    public static void main(String[] args) {
        saveNoCascades();
        deleteCascade();
    }
    public static void delete (){
        tx.begin();
        Parent_Cascade parent = em.find(Parent_Cascade.class, 1L);
        Child_Cascade child1 = em .find(Child_Cascade.class, 2L);
        Child_Cascade child2 = em .find(Child_Cascade.class, 3L);

        em.remove(parent);
        em.remove(child1);
        em.remove(child2);
        tx.commit();
//        기존에 지우려면 이렇게 해야했다
    }

    public static void deleteCascade(){
        tx.begin();
            Parent_Cascade parent = em.find(Parent_Cascade.class, 1L);
            em.remove(parent);
//            CascadeType.REMOVE를 안걸고 이렇게 하면 부모만 지워지는데 무결성 제약조건 때문에 예외가 발생한다.
        tx.commit();
    }

}
