package proxy.eagerloadNlazyload.eager;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString

@Entity
public class TeamEager {
    @Id
    @GeneratedValue
    @Column(name = "TEAM_EAGER_ID")
    private Long id;

    private String name;

}
