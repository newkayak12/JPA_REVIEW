package jpql.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
@Setter
@Getter
@ToString
@Entity
public class Product_jpql {
    @Id
    @GeneratedValue
    @Column(name = "PRODUCT_JPQL_ID")
    private Long id;

    private String name;

    private int price;

    private int stockAmount;
}
