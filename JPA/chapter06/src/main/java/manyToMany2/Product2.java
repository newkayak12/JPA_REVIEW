package manyToMany2;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder

@Entity
public class Product2 {

    @Id
    @Column(name = "PRODUCT2_ID")
    private String id;

    private String name;
}
