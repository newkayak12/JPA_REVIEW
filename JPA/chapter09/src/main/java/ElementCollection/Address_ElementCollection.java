package ElementCollection;

import lombok.*;

import javax.persistence.*;

@NoArgsConstructor
@Setter
@Getter
@EqualsAndHashCode
//참고로 값 타입은 수정, 제거를 위해서 EQUALs와 hashcode를 오버라이드 해야한다.
@Embeddable
public class Address_ElementCollection {

    @Column
    private String city;
    private String street;
    private String zipcode;

    public Address_ElementCollection(String city, String street, String zipcode) {
        this.city = city;
        this.street = street;
        this.zipcode = zipcode;
    }
}
