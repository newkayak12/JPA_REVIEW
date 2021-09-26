package dsl.entity;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
@Data
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
@Builder

@Entity
public class Item_queryDSL {
    @Id
    @GeneratedValue
    @Column(name = "ITEM_QUERYDSL_ID")
    private Long id;

    private String name;
    private String detail;
    private int price;
}
