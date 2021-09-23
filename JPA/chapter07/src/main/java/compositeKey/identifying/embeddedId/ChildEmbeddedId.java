package compositeKey.identifying.embeddedId;

import lombok.EqualsAndHashCode;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;


@Embeddable
@EqualsAndHashCode
public class ChildEmbeddedId implements Serializable {
        private String parentEmbeddedId;
        @Column(name = "CHILDEMBEDDED_ID")
        private String childEmbeddedId;

}
