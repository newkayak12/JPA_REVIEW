package collection;

import collection.entity.MemberSet;
import collection.entity.Team;
import collection.entity.TeamSet;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class OrderByMain {
    static EntityManagerFactory emf = Persistence.createEntityManagerFactory("hibernate");
    static EntityManager em = emf.createEntityManager();
    static EntityTransaction tx = em.getTransaction();

    public static void main(String[] args) {
        order();
    }

    public static void order(){
        tx.begin();
        TeamSet team = new TeamSet("t1");
        MemberSet m1 = new MemberSet("m1", team);
        MemberSet m2 = new MemberSet("m1", team);
        MemberSet m3 = new MemberSet("m2", team);
        MemberSet m4 = new MemberSet("m2", team);
        MemberSet m5 = new MemberSet("m5", team);
        MemberSet m6 = new MemberSet("m3", team);

        team.getMembers().add(m1);
        team.getMembers().add(m2);
        team.getMembers().add(m3);
        team.getMembers().add(m4);
        team.getMembers().add(m5);
        team.getMembers().add(m6);


        em.persist(team);

        tx.commit();

        System.out.println("find================");
        TeamSet findTeam = em.find(TeamSet.class, team.getId());
        System.out.println(findTeam.getMembers().size());

        // @OrderBy로 쿼리문에 알아서 붙여서 컬렉션을 정리해서 나온다.
    }
}
