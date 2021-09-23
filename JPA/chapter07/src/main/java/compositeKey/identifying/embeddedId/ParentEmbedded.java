package compositeKey.identifying.embeddedId;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class ParentEmbedded {
    @Id
    @Column(name = "PARENTEMBEDDED_ID")
    private String parentEmbeddedId;

    private String name;
}
