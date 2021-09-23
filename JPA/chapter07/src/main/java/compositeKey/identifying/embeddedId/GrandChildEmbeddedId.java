package compositeKey.identifying.embeddedId;

import lombok.EqualsAndHashCode;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Embedded;
import java.io.Serializable;

@Embeddable

@EqualsAndHashCode
public class GrandChildEmbeddedId implements Serializable {
    @Embedded
    private ChildEmbeddedId childEmbeddedId;

    @Column(name = "GRANDCHILDEMBEDDED_ID")
    private String grandChildEmbeddedId;



}
