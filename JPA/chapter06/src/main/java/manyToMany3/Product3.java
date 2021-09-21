package manyToMany3;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString

@Entity
public class Product3 {

    @Id
    @Column(name = "PRODUCT3_ID")
    private String id;

    private String name;
}
