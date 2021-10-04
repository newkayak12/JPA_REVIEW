package collection;

import collection.entity.Board;
import collection.entity.Comment;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class OrderColumnMain {
    static EntityManagerFactory emf = Persistence.createEntityManagerFactory("hibernate");
    static EntityManager em = emf.createEntityManager();
    static EntityTransaction tx = em.getTransaction();


    public static void main(String[] args) {
        orderColumn();
    }

    public static void orderColumn(){
        tx.begin();
        Board board = new Board("제목1","내용1");
        em.persist(board);

        Comment comment1 = new Comment("댓글1");
        comment1.setBoard(board);

        board.getComments().add(comment1); //position0
        em.persist(comment1);

        Comment comment2 = new Comment("댓글2");
        comment2.setBoard(board);
        board.getComments().add(comment2); //position1
        em.persist(comment2);

        Comment comment3 = new Comment("댓글3");
        comment3.setBoard(board);
        board.getComments().add(comment3); //position1
        em.persist(comment3);

        Comment comment4 = new Comment("댓글4");
        comment4.setBoard(board);
        board.getComments().add(comment4); //position1
        em.persist(comment4);

        tx.commit();
    }

   /*
        @OrderColumn의 단점
        1. @OrderColumn을 Board 엔티티에서 매핑하므로 Comment는 POSITION의 값을 알 수 없다. 그래서 Comment를 저장할 때는 Position이 저장되지 않는다.
        POSITION은 Board.comments의 위치 값이므로 이 값을 사용해서 POSTITION의 값을 update하는 SQL이 추가로 발생한다.

        2. List를 변경하면 연관된 많은 위치 값을 변경해야한다. 예를 들어 댓글2를 삭제하면 댓글 2,3을 하나씩 당겨야해서 추가적인 update sql이 발생한다.

        3. 중간에 Position값이 없으면 조회한 List에는 null이 보관된다. >> 댓글 2를 DB에서 강제로 삭제하고 다른 댓글들의 POSITION 값을 수정하지 않으면 [0,2,3]이 되어 1이 없어서 인덱스 1 자리에는 null이 반환된다.

    */
}
