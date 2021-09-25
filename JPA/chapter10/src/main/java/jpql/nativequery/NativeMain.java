package jpql.nativequery;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.List;

public class NativeMain {
    static EntityManagerFactory emf = Persistence.createEntityManagerFactory("hibernate");
    static EntityManager em = emf.createEntityManager();
    static EntityTransaction tx = em.getTransaction();

    public static void main(String[] args) {
    useJpql();
    }
    public static void useJpql(){
        Member_native m = new Member_native();
        m.setName("kim");

        tx.begin();
        em.persist(m);
        tx.commit();

        String sql = "select * from MEMBER_NATIVE  where MEMBER_NATIVE_NAME = 'kim'";
//        엔티티 대상이므로 엔티티의 필드명이 들어가야한다. (where 뒤에)
        List<Member_native> ms = em.createNativeQuery(sql, Member_native.class).getResultList();
        System.out.println(ms);
    }
}
