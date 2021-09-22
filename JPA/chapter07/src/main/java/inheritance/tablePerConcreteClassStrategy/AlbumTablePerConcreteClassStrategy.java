package inheritance.tablePerConcreteClassStrategy;

import javax.persistence.Entity;

@Entity
public class AlbumTablePerConcreteClassStrategy extends Item07TablePerConcreteClassStrategy{
    private String director;
    private String actor;

}
