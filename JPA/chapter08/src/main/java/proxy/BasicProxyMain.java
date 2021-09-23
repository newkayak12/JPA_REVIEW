package proxy;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.lang.reflect.Member;

public class BasicProxyMain {
    static EntityManagerFactory emf  = Persistence.createEntityManagerFactory("hibernate08");
    public static void main(String[] args) {
        printUserAndTeam(2L);
        printUser(2L);
    /*
        printUserAndTeam은 둘 다 찾지만
        printUser은 하나만 찾는데 굳이 Team을 불러와야만 할까?
        JPA에서는 이런 문제를 해결하고자 엔티티가 실제로 사용될 떄 까지 데이터베이스 조회를 지연하는 방법을 제공하는데 이것을 '지연 로딩'이라고 한다.
        즉, Team을 사용하는 시점에서 DB에 들러서 부르겠다는 것이다.

        여기서 지연로딩을 사용하려면 TEAM 엔티티 객체 대신 들어갈 가짜 객체가 필요한데, 이를 PROXY라고 한다.
     */

    }


    public static void printUserAndTeam(Long memberId){

        TeamProxy teamProxy = TeamProxy.builder().name("T1").build();
        MemberProxy memberProxy = MemberProxy.builder().userName("member1").teamProxy(teamProxy).build();
        EntityManager em  = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        em.persist(teamProxy);
        em.persist(memberProxy);
        tx.commit();

        MemberProxy member = em.find(MemberProxy.class, memberId);
        TeamProxy team = member.getTeamProxy();

        System.out.println("------------"+team);
        em.close();
        System.out.println("------------"+member);

    }
    public static void printUser(Long memberId){
        EntityManager em = emf.createEntityManager();
        MemberProxy member = em.find(MemberProxy.class, memberId);
        System.out.println("------------"+member);
    }
}
