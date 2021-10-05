package entityGraph.entity;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("Movie")
public class Movie_08 extends Item_08 {
    private String director;
    private String actor;
}
