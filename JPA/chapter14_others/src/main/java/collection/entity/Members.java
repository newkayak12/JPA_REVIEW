package collection.entity;

import javax.persistence.*;

@Table(name = "Members14")
@Entity
public class Members {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
}
