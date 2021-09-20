package chpater05.biDirectional;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.List;

public class biDirectionalMain {
    static EntityManagerFactory emf = Persistence.createEntityManagerFactory("hibernate");

    public static void main(String[] args) {
        testSave();
        biDirectionalFind();
//       따로 객체에 넣지 않아도 알아서 COLLECTION으로 반환된다.
//        이로써 Table과 같이 외래키로 이어진 관계와 같이 표현할 수 있다.

    }

    public static void testSave(){
        /*

            HIBERNATE가 모든 ENTITY를 스캔한 후 올리기 떄문에 하나의 프로젝트에 같은 테이블에 저장하는 ENTITY를 선언하면 DDL이 쓸모 없는 컬럼도 만들어버림

         */

        //팀 1 저장
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        Team team1 = new Team("T1","팀1");
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
    public static void biDirectionalFind(){

        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin();
           Team team = em.find(Team.class, "T1");
           List<Member> members = team.getMembers();

           for(Member member : members  ){
               System.out.println("member.userName = "+member.getUserName());
           }




    }
}
