package manyToMany.oneWay;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder

@Entity
public class ProductOneWay {
    @Id
    @Column(name = "PRODUCTONEWAY_ID")
    private String id;

    private String name;



}
