package inheritance.joinStrategy;

import javax.persistence.*;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
//    상속 매핑을 위해서 부모 클래스에 Inheritance를 선언한다. 매핑 전략을 지정해야하는데, 여기에서는 조인 전략을 사용하므로 inheritanceType.JOINED를 사용했다.
@DiscriminatorColumn(name = "DTYPE")
//    부모 클래스에 구분 컬럼을 지정해준다. 이 컬럼으로 자식 테이블을 구분한다.
public abstract class Item07Joined {
    @Id
    @GeneratedValue
    @Column(name = "ITEM07JOINED_ID")
    private Long id;

    private String name;
    private int price;

}
