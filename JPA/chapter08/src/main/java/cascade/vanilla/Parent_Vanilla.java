package cascade.vanilla;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor

//@Entity
public class Parent_Vanilla {
    @Id
    @GeneratedValue
    @Column(name = "PARENT_CASCADE_ID")
    private Long id;

    @OneToMany(mappedBy = "parent")
    private List<Child_Vanilla> children = new ArrayList<>();
}
