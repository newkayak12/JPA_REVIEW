package entity;

import entity.baseEntity.BaseEntity_07;
import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor

@Entity
public class Category_07 extends BaseEntity_07 {
    @Id
    @GeneratedValue
    @Column(name = "CATEGORY_07_ID")
    private Long id;

    private String name;

//    Items
    @ManyToMany
    @JoinTable(name = "CATEGORY_ITEM_07", joinColumns = @JoinColumn(name = "CATEGORY_07_ID"), inverseJoinColumns = @JoinColumn(name = "ITEM_07_ID"))
    private List<Item_07> item07List = new ArrayList<>();

//    Parent
    @ManyToOne
    @JoinColumn(name = "PARENTS_07_ID")
    private Category_07 parent;

//    child
    @OneToMany(mappedBy = "parent")
    private List<Category_07> child = new ArrayList<>();

    public void addChildCategory(Category_07 category07){
        this.child.add(category07);
        category07.setParent(this);
    }

    public void addItem(Item_07 item){
        item07List.add(item);
    }
}
