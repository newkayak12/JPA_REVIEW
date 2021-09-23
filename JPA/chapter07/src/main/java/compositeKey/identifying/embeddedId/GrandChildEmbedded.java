package compositeKey.identifying.embeddedId;

import javax.persistence.*;

@Entity
public class GrandChildEmbedded {


    @EmbeddedId
    private GrandChildEmbeddedId grandChildEmbeddedIdRef;

    /*

        식별관계로 사용하려면 MapsId로 연관관계를 주면 된다.
     */
    @MapsId("childEmbeddedId")
    @ManyToOne
    @JoinColumns({
            @JoinColumn(name = "PARENTEMBEDDED_ID"),
            @JoinColumn(name = "CHILDEMBEDDED_ID")
    })
    private ChildEmbedded childEmbedded;

    private String name;
}
