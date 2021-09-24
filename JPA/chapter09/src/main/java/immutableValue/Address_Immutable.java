package immutableValue;

import java.util.Objects;

public class Address_Immutable {
    private String city;

    protected Address_Immutable(){
    }

    public Address_Immutable(String city){
        this.city = city;
    }

    public String getCity(){
        return city;
    }
//    setter는 만들지 않는다.
    /*
        만들고 싶으면 아예 새로운 객체를 만들어야 하며, 수정을 용납하지 않는다.
        추가적으로 값 타입의 비교를 위해서 equals와 hashcode를 오버라이드 해야한다.
     */

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Address_Immutable that = (Address_Immutable) o;
        return Objects.equals(city, that.city);
    }

    @Override
    public int hashCode() {
        return Objects.hash(city);
    }
}
