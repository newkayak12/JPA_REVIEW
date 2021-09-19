package jpabook.start.chpater05.relationshipWithJpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import static jpabook.start.entityTemplate.EntityTemplate.*;

public class ManyToOneCRUD {


    public void testSave(){
        //팀 1 저장
        EntityManager em = getEntityManager();
        transactionBegin();
        Team team1 = new Team("team1","팀");
        em.persist(team1);

        Member member1 = Member.builder().id("member1").userName("회원1").build();
        member1.setTeam(team1);
        em.persist(member1);

        Member member2 = Member.builder().id("member2").userName("회원2").build();
        member2.setTeam(team1);
        em.persist(member2);

        transactionCommit();
        
    }
}
