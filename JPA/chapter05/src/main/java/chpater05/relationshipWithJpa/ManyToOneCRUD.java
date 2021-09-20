package chpater05.relationshipWithJpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import java.util.List;


public class ManyToOneCRUD {

    public static EntityManagerFactory emf = Persistence.createEntityManagerFactory("hibernate");

    public static void main(String[] args) {
        testSave();
//        저장

        testFind();
//       객체 그래프 탐색

        testUpdate();
//        업데이트 > find로 찾고 엔티티를 수정하면 트랜잭션 수행 시, 알아서 수정되는 구조임

        removeRelation();
//        연관관계 제거

        jpql();
//        JPQL을 이용한 조인
    }
    public static void testFind(){
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin();
            Member m = em.find(Member.class,"member1");
            Team t = m.getTeam();
            System.out.println(m + " : " + t);
        tx.commit();
    }

    public static void jpql(){
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        String jpql = "select m from Member m join m.team t where " + "t.name = :teamName";
//       JPQL은 테이블이 아닌 ENTITY를 대상으로 한다.

        List<Member> resultList = em.createQuery(jpql, Member.class).setParameter("teamName", "팀").getResultList();

        for(Member m : resultList){
            System.out.println("[query] member.userName = " + m.getUserName());
        }

    }

    public static void removeRelation(){
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin();
            Member m = em.find(Member.class , "member2");
            m.setTeam(null);
        tx.commit();

        /*
             연관관계에 있는 테이블을 삭제하려면 일단 연관관계에 종속된 테이블을 제거한 후 제거해야한다.
             그렇지 않으면 제약조건에 부딪힌다.
         */
    }


    public static void testUpdate(){
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin();
            Team t2 = Team.builder().id("team2").name("팀2").build();
            em.persist(t2);
            Member m = em.find(Member.class, "member1");
            m.setTeam(t2);
        tx.commit();
    }


    public static void testSave(){
        /*

            HIBERNATE가 모든 ENTITY를 스캔한 후 올리기 떄문에 하나의 프로젝트에 같은 테이블에 저장하는 ENTITY를 선언하면 DDL이 쓸모 없는 컬럼도 만들어버림

         */

        //팀 1 저장
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin();
            Team team1 = new Team("team1","팀");
            em.persist(team1);

            Member member1 = new Member("member1","회원1");
            member1.setTeam(team1);
            System.out.println(member1);
            em.persist(member1);

            Member member2 = new Member("member2","회원2");
            member2.setTeam(team1);
            System.out.println(member2);
            em.persist(member2);

        tx.commit();


    }
}
