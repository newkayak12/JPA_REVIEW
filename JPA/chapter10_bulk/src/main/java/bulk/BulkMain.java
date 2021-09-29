package bulk;

import entity.Item_bulk;
import entity.Item_bulk_temp;

import javax.persistence.*;
import java.util.List;

public class BulkMain {
    static EntityManagerFactory emf = Persistence.createEntityManagerFactory("hibernate");
    static EntityManager em = emf.createEntityManager();
    static EntityTransaction tx = em.getTransaction();

    public static void main(String[] args) {
        bulkUpdate();
//        bulkDelete();
            bulkInsert();
    }
    public static void insert(){
        Item_bulk i1 = Item_bulk.builder().itemBulkName("i1").itemBulkPrice(200).itemBulkStock(40).build();
        Item_bulk i2 = Item_bulk.builder().itemBulkName("i2").itemBulkPrice(100).itemBulkStock(320).build();
        Item_bulk i3 = Item_bulk.builder().itemBulkName("i3").itemBulkPrice(400).itemBulkStock(12).build();
        Item_bulk i4 = Item_bulk.builder().itemBulkName("i4").itemBulkPrice(600).itemBulkStock(41).build();
        Item_bulk i5 = Item_bulk.builder().itemBulkName("i5").itemBulkPrice(200).itemBulkStock(423).build();
        Item_bulk i6 = Item_bulk.builder().itemBulkName("i6").itemBulkPrice(2300).itemBulkStock(45).build();
        Item_bulk i7 = Item_bulk.builder().itemBulkName("i7").itemBulkPrice(800).itemBulkStock(48).build();
        Item_bulk i8 = Item_bulk.builder().itemBulkName("i8").itemBulkPrice(900).itemBulkStock(70).build();
        Item_bulk i9 = Item_bulk.builder().itemBulkName("i9").itemBulkPrice(4200).itemBulkStock(60).build();
        Item_bulk i10 = Item_bulk.builder().itemBulkName("i10").itemBulkPrice(2230).itemBulkStock(60).build();
        Item_bulk i11 = Item_bulk.builder().itemBulkName("i11").itemBulkPrice(210).itemBulkStock(50).build();
        Item_bulk i12 = Item_bulk.builder().itemBulkName("i12").itemBulkPrice(250).itemBulkStock(48).build();
        Item_bulk i13 = Item_bulk.builder().itemBulkName("i13").itemBulkPrice(220).itemBulkStock(90).build();
        Item_bulk i14 = Item_bulk.builder().itemBulkName("i14").itemBulkPrice(206).itemBulkStock(23).build();
        Item_bulk i15 = Item_bulk.builder().itemBulkName("i15").itemBulkPrice(203).itemBulkStock(422).build();

        tx.begin();
            em.persist(i1);
            em.persist(i2);
            em.persist(i3);
            em.persist(i4);
            em.persist(i5);
            em.persist(i6);
            em.persist(i7);
            em.persist(i8);
            em.persist(i9);
            em.persist(i10);
            em.persist(i11);
            em.persist(i12);
            em.persist(i13);
            em.persist(i14);
            em.persist(i15);
        tx.commit();
    }
    public static void bulkUpdate(){
        insert();
        tx.begin();
        String query = "UPDATE Item_bulk i SET i.itemBulkPrice = (i.itemBulkPrice  * 1.1) WHERE i.itemBulkStock < :itemBulkStock";
//        String query = "UPDATE ITEM_BULK i SET i.ITEM_BULK_PRICE = (i.ITEM_BULK_PRICE  * 1.1) WHERE i.ITEM_BULK_STOCK < :itemBulkStock";
        System.out.println("------update------");
        int resultCount = em.createQuery(query).setParameter("itemBulkStock", 40).executeUpdate();
//        int resultCount = em.createNativeQuery(query).setParameter("itemBulkStock", 40).executeUpdate();
        System.out.println("update : "+ resultCount);
        tx.commit();

    }
    public static void bulkDelete(){
        tx.begin();
        String query = "DELETE Item_bulk i WHERE i.itemBulkPrice < :itemBulkPrice";
//        String query = "DELETE ITEM_BULK i WHERE i.ITEM_BULK_PRICE < :itemBulkPrice";
        System.out.println("------delete------");
        int resultCount = em.createQuery(query).setParameter("itemBulkPrice", 600).executeUpdate();
//        int resultCount = em.createNativeQuery(query).setParameter("itemBulkPrice", 600).executeUpdate();
//        네이티브 쿼리가 아니라 JPQL 로도 가능하다.
        System.out.println("delete : "+ resultCount);
        tx.commit();
    }
    public static void bulkInsert(){
        /*
            하이버 네이트는 INSERT 벌크 연산도 지원한다. 물론 JPA표준은 아니다.
         */
        String query = "INSERT INTO Item_bulk_temp (id, itemBulkTempName, itemBulkTempPrice, itemBulkTempStock) SELECT i.id, i.itemBulkName, i.itemBulkPrice, i.itemBulkStock FROM Item_bulk i where i.itemBulkPrice > :itemBulkPrice";
//        String query = "INSERT INTO Item_bulk_temp (ITEM_BULK_TEMP_ID, item_Bulk_Temp_Name, item_Bulk_Temp_Price, item_Bulk_Temp_Stock) SELECT i.ITEM_BULK_ID, i.item_Bulk_Name, i.item_Bulk_Price, i.item_Bulk_Stock FROM Item_bulk i where i.item_Bulk_Price > :itemBulkPrice";
        tx.begin();
        int count = em.createQuery(query).setParameter("itemBulkPrice",600).executeUpdate();
//        int count = em.createNativeQuery(query).setParameter("itemBulkPrice", 600).executeUpdate();
        tx.commit();
        TypedQuery<Item_bulk_temp> queries = em.createQuery("select i from Item_bulk_temp i", Item_bulk_temp.class);
        List<Item_bulk_temp> list = queries.getResultList();
        System.out.println(list);
    }
}
