package criteria.dynamicQuery;

import criteria.Member_criteria;
import criteria.Team_criteria;

import javax.persistence.*;
import javax.persistence.criteria.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DynamicMain {
    static EntityManagerFactory emf = Persistence.createEntityManagerFactory("hibernate");
    static EntityManager em = emf.createEntityManager();
    static EntityTransaction tx = em.getTransaction();

    public static void main(String[] args) {
//        List<String> test = new ArrayList<>();
//        test.add("1");
//        test.add("2");
//        test.add("3");
//        System.out.println(test.toArray(new String[0]) instanceof String[]);

    }
    public static void jpqldynamic(){
//    조건
        Integer age = 10;
        String userName = null;
        String teamName = "팀A";

//    동적 쿼리
        StringBuilder jpql = new StringBuilder("select m from Member_criteria m join m.team t");
        List<String> criteria = new ArrayList<>();

        if(age != null){
            criteria.add("m.age = :age");
        }
        if(userName != null){
            criteria.add("m.name = :userName");
        }
        if(teamName != null){
            criteria.add("t.name = :teamName");
        }
        if(criteria.size()>0){
            jpql.append(" where ");
        }
        for(int i = 0; i< criteria.size(); i++){
            if(i>0){
                jpql.append(" and ");
            }
            jpql.append(criteria.get(i));
        }

        TypedQuery<Member_criteria> query = em.createQuery(jpql.toString(), Member_criteria.class);
        if(age!=null){
            query.setParameter("age", age);
        }
        if(userName != null){
            query.setParameter("userName", userName);
        }
        if(teamName!=null){
            query.setParameter("teamName", teamName);
        }

        List<Member_criteria> resultList = query.getResultList();
    }
    public static void criteriaDynamic(){
        Integer age = 10;
        String userName = null;
        String teamName = "팀A";

//        Criteria 동적 쿼리

        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Member_criteria> cq = cb.createQuery(Member_criteria.class);

        Root<Member_criteria> m = cq.from(Member_criteria.class);
        Join<Member_criteria, Team_criteria> t = m.join("team");

        List<Predicate> criteria = new ArrayList<>();

        if(age!=null){
            criteria.add(cb.equal(m.<Integer>get("age"),cb.parameter(Integer.class,"age")));
        }
        if(userName !=null){
            criteria.add(cb.equal(m.get("userName"),cb.parameter(String.class, "userName")));
        }
        if(teamName != null){
            criteria.add(cb.equal(t.get("name"), cb.parameter(String.class,"teamName")));
        }

        cq.where(cb.and(criteria.toArray(new Predicate[0])));
//        ??
//        Predicate 배열 0개 짜리로 만들어 넣는다?

        /*
            길이가 0이든 1이든 모두 반환하는데,
            new로 새로운 배열 안쓰면 Object로 반환해서
            new로 자료형 잡아준 것 같음
         */

        TypedQuery<Member_criteria> query = em.createQuery(cq);
        if(age != null){
            query.setParameter("age",age);
        }
        if(userName != null){
            query.setParameter("userName", userName);
        }
        if(teamName != null){
            query.setParameter("teamName", teamName);
        }
        List<Member_criteria> resultLIst = query.getResultList();
    }

}
