package compositeKey.identifying.IdClass;

import lombok.EqualsAndHashCode;

import java.io.Serializable;

@EqualsAndHashCode
public class GrandChildIdentiIdClassId implements Serializable {

    private ChildIdentiIdClassId childId;
    private String grandChildid;
}
