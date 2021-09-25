package criteria.dynamicQuery;

import criteria.Member_criteria;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

public class DynamicMain {
    static EntityManagerFactory emf = Persistence.createEntityManagerFactory("hibernate");
    static EntityManager em = emf.createEntityManager();
    static EntityTransaction tx = em.getTransaction();

    public static void main(String[] args) {

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
}
