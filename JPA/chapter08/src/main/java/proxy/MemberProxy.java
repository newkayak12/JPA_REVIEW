package proxy;

import lombok.*;

import javax.persistence.*;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString

@Entity
public class MemberProxy {
    @Id
    @GeneratedValue
    @Column(name = "MEMBER_PROXY_ID")
    private Long id;

    private String userName;

    @ManyToOne
    private TeamProxy teamProxy;



}
