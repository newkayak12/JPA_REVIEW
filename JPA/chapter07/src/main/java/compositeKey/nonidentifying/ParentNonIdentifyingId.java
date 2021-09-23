package compositeKey.nonidentifying;

import lombok.EqualsAndHashCode;

import java.io.Serializable;

@EqualsAndHashCode
public class ParentNonIdentifyingId implements Serializable {
    private String id1;
    private String id2;

    public ParentNonIdentifyingId() {
    }

    public ParentNonIdentifyingId(String id1, String id2) {
        this.id1 = id1;
        this.id2 = id2;
    }
}
