package jpql.entity;

import lombok.EqualsAndHashCode;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Embeddable;
@Setter
@ToString
@EqualsAndHashCode
@Embeddable
public class Address_jpql {
    private String city;
    private String street;
    private String zipcode;
}
