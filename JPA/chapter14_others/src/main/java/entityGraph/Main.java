package entityGraph;

import entityGraph.entity.Order_08;

import javax.persistence.*;
import java.util.HashMap;
import java.util.Map;

public class Main {
    static EntityManagerFactory emf = Persistence.createEntityManagerFactory("hibernate");
    static EntityManager em = emf.createEntityManager();
    static EntityTransaction tx = em.getTransaction();

    public static void main(String[] args) {

            entityGraph();
    }
    public static void entityGraph(){
        EntityGraph graph = em.getEntityGraph("Order_08.with Member_08");
        Map hints = new HashMap();
        hints.put("javax.persistence.fetchgraph", graph);

//        Order_08 order08 = em.find(Order_08.class, orderId hints);
        //  책과는 다르게 orderId가 문제가 된다. 
    }

}
