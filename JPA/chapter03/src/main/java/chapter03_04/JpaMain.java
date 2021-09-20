package chapter03_04;

import chapter03_04.identityStrategy.AutoBoard;
import chapter03_04.identityStrategy.AutoIncrementBoard;
import chapter03_04.identityStrategy.SequenceBoard;
import chapter03_04.identityStrategy.TableBoard;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class JpaMain {
    public static EntityManagerFactory emf = Persistence.createEntityManagerFactory("hibernate");

    static Member createMember(String id,  String userName) {
        EntityManager em1 = emf.createEntityManager();
        EntityTransaction tx1 = em1.getTransaction();
        tx1.begin();

        Member entity = Member.builder().age(26).id(id).userName(userName).build();
        em1.persist(entity);
        tx1.commit();
        return entity;
    }

    static AutoIncrementBoard createBoardByAutoIncrement (String data){
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();

        tx.begin();
        AutoIncrementBoard board = AutoIncrementBoard.builder().data(data).build();
        em.persist(board);
        tx.commit();
        em.close();
        return board;
    }
    static SequenceBoard createBoardBySequence (String data){
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();

        tx.begin();
        SequenceBoard board = SequenceBoard.builder().data(data).build();
        em.persist(board);
        tx.commit();
        em.close();
        return board;
    }
    static TableBoard createBoardByTable (String data){
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();

        tx.begin();
        TableBoard board = TableBoard.builder().data(data).build();
        em.persist(board);
        tx.commit();
        em.close();
        return board;
    }
    static AutoBoard createBoardByAuto (String data){
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();

        tx.begin();
        AutoBoard board = AutoBoard.builder().data(data).build();
        em.persist(board);
        tx.commit();
        em.close();
        return board;
    }

    static void autoincre(){
        AutoIncrementBoard board1 = createBoardByAutoIncrement("A");
        AutoIncrementBoard board2 = createBoardByAutoIncrement("B");
        AutoIncrementBoard board3 = createBoardByAutoIncrement("C");
        AutoIncrementBoard board4 = createBoardByAutoIncrement("D");
        System.out.println(board1);
        System.out.println(board2);
        System.out.println(board3);
        System.out.println(board4);
    }
    static void sequence(){
        SequenceBoard b1 = createBoardBySequence("A");
        SequenceBoard b2 = createBoardBySequence("B");
        SequenceBoard b3 = createBoardBySequence("C");

        System.out.println(b1);
        System.out.println(b2);
        System.out.println(b3);
    }

    static void table(){
        TableBoard b1 = createBoardByTable("A");
        TableBoard b2 = createBoardByTable("B");
        TableBoard b3 = createBoardByTable("C");

        System.out.println(b1);
        System.out.println(b2);
        System.out.println(b3);
    }

    static void auto(){
        AutoBoard b1 = createBoardByAuto("A");
        AutoBoard b2 = createBoardByAuto("B");
        AutoBoard b3 = createBoardByAuto("C");
        System.out.println(b1);
        System.out.println(b2);
        System.out.println(b3);
    }
    public static void main(String[] args) {
//        Member member = createMember("lzyjin", "김예진");
//        System.out.println(member);

//            autoincre();
//            sequence();
//              table();
                auto();

    }


}
