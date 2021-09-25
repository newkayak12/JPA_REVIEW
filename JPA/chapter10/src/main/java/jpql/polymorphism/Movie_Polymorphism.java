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
@DiscriminatorValue("MOIVE")
public class Movie_Polymorphism  extends  Item_Polymorphism{
    private String director;
    private String actor;
}
