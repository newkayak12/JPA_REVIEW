package embedded.embeddedPlus;

import javax.persistence.Embeddable;
import javax.persistence.Embedded;

@Embeddable
public class Address_embeddedplus {
    String street;
    String city;
    String state;

    @Embedded
    Zipcode_embeddedplus zipcode;

}
