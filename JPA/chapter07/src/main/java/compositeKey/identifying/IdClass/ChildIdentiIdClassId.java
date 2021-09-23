package compositeKey.identifying.IdClass;


import java.io.Serializable;
import java.util.Objects;


public class ChildIdentiIdClassId implements Serializable {
    private String parentId;
    private String childId;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ChildIdentiIdClassId that = (ChildIdentiIdClassId) o;
        return Objects.equals(parentId, that.parentId) && Objects.equals(childId, that.childId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(parentId, childId);
    }
}
