package entity;

import entity.baseEntity.BaseEntity_08;

import java.util.ArrayList;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "DTYPE")
public abstract class Item_08 extends BaseEntity_08 {
    @Id
    @GeneratedValue
    @Column(name = "ITEM_07_ID")
    private Long id;

    private String name;

    private int price;

    private int stockQuantity;

//    category
    @ManyToMany(mappedBy = "item08List")
    private List<Category_08> category08List = new ArrayList<>();



}
