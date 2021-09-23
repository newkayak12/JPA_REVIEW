package cascade.vanilla;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor

//@Entity
public class Child_Vanilla {
    @Id
    @GeneratedValue
    @Column(name = "CHILD_CASCADE_ID")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "PARENT_CASCADE_ID")
    private Parent_Vanilla parent;
}
