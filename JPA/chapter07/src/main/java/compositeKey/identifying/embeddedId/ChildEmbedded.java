package compositeKey.identifying.embeddedId;

import javax.persistence.*;

@Entity
public class ChildEmbedded {

    @EmbeddedId
    private ChildEmbeddedId childEmbeddedIdRef;

    @MapsId("parentEmbeddedId")
    @ManyToOne
    @JoinColumn(name = "PARENTEMBEDDED_ID")
    private ParentEmbedded parentEmbedded;

    private String name;
}
