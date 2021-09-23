package proxy.eagerloadNlazyload.lazy;

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
public class TeamLazy {
    @Id
    @GeneratedValue
    @Column(name = "TEAM_LAZY_ID")
    private Long id;

    private String name;

}
