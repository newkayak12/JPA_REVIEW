package embedded.embeddedPlus.attributeOverride;

import embedded.embeddedPlus.Address_embeddedplus;

import javax.persistence.*;

@Entity
public class Member_AttributeOverride {
    @Id
    @GeneratedValue
    private  Long id;
    private  String name;

//    @Embedded
//    Address_embeddedplus homeAddress;
//
//    @Embedded
//    Address_embeddedplus companyAddress;

//            이와 같이 같은 임베디드 형을 여러 개 지정할 수 있다.
//    문제는 테이블에 매핑하는 컬럼명이 중복된다는 것이다.
//    이런 경우에는 @AttributeOverride를 통해서 매핑 정보를 재정의 해야한다.


//    >>>>>>>>>>>>>>>>>>>>>>>>
    @Embedded
    @AttributeOverrides({@AttributeOverride(name = "city", column = @Column(name = "COMPANY_CITY")), @AttributeOverride(name = "street", column = @Column(name = "COMPANY_STREET")), @AttributeOverride(name = "zipcode", column = @Column(name = "COMPANY_ZIPCODE"))})
    Address_embeddedplus companyAddress;
//    <<<<<<<<<<<<<<<<<<<<<<<<
}
