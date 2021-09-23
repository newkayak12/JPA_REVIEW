package proxy.eagerloadNlazyload.example;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.Date;
import java.util.List;

public class Main {
    static EntityManagerFactory emf = Persistence.createEntityManagerFactory("hibernate08");
    static EntityManager em = emf.createEntityManager();
    static EntityTransaction tx = em.getTransaction();

    public static void main(String[] args) {
        insert();
        show();
    }
    public static void insert(){
        TeamExample t = new TeamExample();
        t.setId("t1");
        t.setName("팀1");
        OrderExample o = new OrderExample();
        o.setId("o1");
        o.setOrderDate(new Date());
        MemberExample m = new MemberExample();
        m.setAge(19);
        m.setId("m1");
        m.setUsername("이름");
        ProductExample p = new ProductExample();
        p.setId("p1");
        p.setProductName("pname");
        p.setProductPrice(1000);
        o.setProduct(p);
        m.addTeam(t);
        m = o.addMember(m);

        tx.begin();
        em.persist(p);
        em.persist(t);
        em.persist(o);
        em.persist(m);
        tx.commit();

    }

    public static void show(){
        tx.begin();
        MemberExample m = em.find(MemberExample.class, "m1");
        System.out.println("++++++++"+m);
        List<OrderExample> olist = m.getOrders();
        System.out.println("++++++++"+olist.getClass().getName());
//        여기까지는 그냥 persistentBag
        System.out.println(olist.get(0));
//        이렇게 실질적으로 호출해야 DB에서 호출된다.
        /*
            참고로 order, member 둘 다 toString을 오버라이드 하면 계속 toString으로 객체를 풀어내느라 stackoverflow가 발생한다.
         */
        em.close();
    }

}
