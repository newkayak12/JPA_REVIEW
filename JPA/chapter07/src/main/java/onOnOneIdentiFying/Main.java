package onOnOneIdentiFying;

import javax.persistence.*;

public class Main {
    static EntityManagerFactory emf = Persistence.createEntityManagerFactory("hibernate");

    public static void main(String[] args) {
        save();
    }
    public static void save(){
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();

        tx.begin();
        BoardIden board = BoardIden.builder().title("제목").build();
        em.persist(board);

        BoardDetailIden boardDetail = BoardDetailIden.builder().content("내용").boardIden(board).build();
        em.persist(boardDetail);
        tx.commit();
    }
}
