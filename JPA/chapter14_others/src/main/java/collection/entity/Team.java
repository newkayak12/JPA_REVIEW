package collection.entity;

import java.util.*;

import javax.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "TEAM14")
@Entity
public class Team {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private String id;

	@OneToMany
	@JoinColumn
	private Collection<Members> members = new ArrayList<>();

	@OneToMany
	@JoinColumn
	private List<Members> membersList = new ArrayList<>();

	@OneToMany
	@JoinColumn
	private Set<Members> set = new HashSet<>();

	@OneToMany
	@OrderColumn
	private List<Members> memberOrderList = new ArrayList<>();
	
}
