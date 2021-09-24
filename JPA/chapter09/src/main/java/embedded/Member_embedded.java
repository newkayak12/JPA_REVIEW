package embedded;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Member_embedded {
//    새로운 값 타입을 직접 정의해서 사용할 수 있는데 JPA에서는 이를 임베디드 타입이라고 한다.
    @Id
    @GeneratedValue
    private Long id;

    private String name;

//    @Temporal(TemporalType.DATE)
//    private Date startDate;
//
//    @Temporal(TemporalType.DATE)
//    private Date endDate;
//    private String city;
//    private String street;
//    private String zipcode;

//    기본형과 다를 바가 없다.

    @Embedded
    Period worPeriod;
    @Embedded
    Address homeAddress;

    //응집력이 높다.
    //UML로 표현하면 composition 관계이다.
//

}
