package jpql.polymorphism;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
@Getter
@Setter
@ToString
@Entity
@DiscriminatorValue("ALBUM")
public class Album_Polymorphism extends Item_Polymorphism{
    private String singer;
}
