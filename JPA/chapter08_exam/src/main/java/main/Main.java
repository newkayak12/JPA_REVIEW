package main;

import entity.Delivery_08;
import entity.OrderItem_08;
import entity.Order_08;
import entity.enums.DeliverStatus_08;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class Main {
    static EntityManagerFactory emf = Persistence.createEntityManagerFactory("hibernate");
    static EntityManager em = emf.createEntityManager();
    static EntityTransaction tx = em.getTransaction();

    public static void main(String[] args) {
        save();
    }

    public static void save(){
        Delivery_08 delivery08 = new Delivery_08();
        OrderItem_08 orderItem08_1 = new OrderItem_08();
        OrderItem_08 orderItem08_2 = new OrderItem_08();

        Order_08 order08 = new Order_08();
        order08.addDelivery(delivery08);

        order08.addOrderItem(orderItem08_1);
        order08.addOrderItem(orderItem08_2);
        tx.begin();
        em.persist(order08);
        tx.commit();

    }
}
