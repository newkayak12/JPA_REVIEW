package manyToMany2;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.Objects;

@Setter
@Getter

public class BuyerProduct2ID implements Serializable {
//    클래스의 직렬화를 통해서 비교를 할 준비를 한다.
    private String buyer2;
    private String product2;

//    각 필드의 기본키를 담아놓는다.

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BuyerProduct2ID that = (BuyerProduct2ID) o;
        return Objects.equals(buyer2, that.buyer2) && Objects.equals(product2, that.product2);
    }

    @Override
    public int hashCode() {
        return Objects.hash(buyer2, product2);
    }
//    Equals와 hashcode 오버라이드로 비교할 준비를 마친다.

}
