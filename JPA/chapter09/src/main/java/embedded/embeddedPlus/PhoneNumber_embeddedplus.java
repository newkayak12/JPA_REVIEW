package embedded.embeddedPlus;

import javax.persistence.Embeddable;
import javax.persistence.ManyToOne;

@Embeddable
public class PhoneNumber_embeddedplus {
    String areaCode;
    String localNumber;
    @ManyToOne PhonServicePrivder provider;
}
