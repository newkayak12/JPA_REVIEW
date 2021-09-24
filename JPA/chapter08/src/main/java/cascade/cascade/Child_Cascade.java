package cascade.cascade;

import lombok.*;

import javax.persistence.*;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor

@Entity
public class Child_Cascade {
    @Id
    @GeneratedValue
    private Long id;

    @ManyToOne
    private Parent_Cascade parent;
}
