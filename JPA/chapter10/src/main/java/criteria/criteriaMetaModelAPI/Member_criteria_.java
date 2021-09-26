package criteria.criteriaMetaModelAPI;

import criteria.Member_criteria;
import criteria.Team_criteria;

import javax.annotation.processing.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Member_criteria.class)
public class Member_criteria_ {
    public static volatile SingularAttribute<Member_criteria,Long> id;
    public static volatile SingularAttribute<Member_criteria,String> name;
    public static volatile SingularAttribute<Member_criteria, Integer> age;
    public static volatile SingularAttribute<Member_criteria, Team_criteria> team;

//    물론 개발자가 이를 다 만들지는 않는다.
    /*
        코드 생성기는 org.hibernate.jpamodel.JPAMetaModelEntityProcessor를 사용한다.
        코드 생성기는 따로 Maven Repo에서 찾아서 받으면 된다.
     */
}
