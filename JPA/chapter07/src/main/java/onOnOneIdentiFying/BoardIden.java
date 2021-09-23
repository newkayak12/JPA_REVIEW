package onOnOneIdentiFying;

import lombok.*;

import javax.persistence.*;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString

@Entity
public class BoardIden {
    @Id
    @GeneratedValue
    @Column(name = "BOARD_IDEN_ID")
    private Long id;

    private String title;

    @OneToOne(mappedBy = "boardIden")
    private BoardDetailIden boardDetailIden;
}
