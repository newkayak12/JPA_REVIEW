package jpql.polymorphism;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
@Setter
@Getter
@Entity
@ToString

@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "DTYPE")
/*
    상속구조에서 조회 대상을 특정 자식 타입으로 한정할 떄 주로 사용한다.
 */
public abstract class Item_Polymorphism {
    @Id
    @GeneratedValue
    @Column(name = "ITEM_POLYMORPHISM_ID")
    private Long id;

    private String name;

    private int price;

    private int stockQuantity;
}
