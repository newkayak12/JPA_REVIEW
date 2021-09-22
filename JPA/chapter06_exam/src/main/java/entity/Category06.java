package entity;

import lombok.*;

import javax.persistence.*;
import java.sql.Array;
import java.util.ArrayList;
import java.util.List;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder

@Entity
public class Category06 {
    @Id
    @GeneratedValue
    @Column(name = "CATEGORY06_ID")
    private Long id;

    private String name;

    @ManyToMany
    @JoinTable(name = "CATEGORY_ITEM06", joinColumns = @JoinColumn(name = "CATEGORY06_ID"),inverseJoinColumns = @JoinColumn(name = "ITEM06_ID"))
    private List<Item06> item06s = new ArrayList<>();

    @ManyToOne
    @JoinColumn(name = "PARENTS_ID")
    private Category06 parent;

    @OneToMany(mappedBy = "parent")
    private List<Category06> child = new ArrayList<>();

    public void addChildCategory(Category06 category06){
        this.child.add(category06);
        category06.setParent(this);
    }

    public void addItem(Item06 item){
        item06s.add(item);
    }

}
