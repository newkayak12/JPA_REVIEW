package onOnOneIdentiFying;

import lombok.*;

import javax.persistence.*;
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString

@Entity
public class BoardDetailIden {
    @Id
    private Long boardId;

    @MapsId
    @OneToOne
    @JoinColumn(name = "BOARD_IDEN_ID")
    private BoardIden boardIden;

    private String content;
}
