package compositeKey.embeddedIdExam;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@EqualsAndHashCode
@ToString
@Embeddable
public class ParentEmbeddedIdId implements Serializable {
    @Column(name = "PARENTEMBEDDEDID_ID1")
    private String id1;
    @Column(name = "PARENTEMBEDDEDID_ID2")
    private String id2;
}
