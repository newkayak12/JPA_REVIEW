package entity.valueType;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Embeddable;

@Getter
@Setter
@EqualsAndHashCode

@Embeddable
public class Address_09 {
    private String city;
    private String street;
    private String zipcode;
}
