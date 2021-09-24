package embedded.embeddedPlus;

import embedded.Address;
import embedded.Period;

import javax.persistence.Embedded;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

public class Member_embeddedPlus {
    @Id
    @GeneratedValue
    private Long id;

    private String name;

    @Embedded
    PhoneNumber_embeddedplus phoneNumber;

    @Embedded
    Address_embeddedplus address;

//    이렇게 엔티티든 임베디드 이든 여러 개 사용 할 수 있다.

}
