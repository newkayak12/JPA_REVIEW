package cascade.cascade;

import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString

@Entity
public class Parent_Cascade {
    @Id
    @GeneratedValue
    private Long id;
    @OneToMany(mappedBy = "parent", cascade = {CascadeType.PERSIST, CascadeType.REMOVE}, orphanRemoval = true)
    //cascade류 + orphanRemoval(고아객체 삭제)
    private List<Child_Cascade> children = new ArrayList<>();
}
