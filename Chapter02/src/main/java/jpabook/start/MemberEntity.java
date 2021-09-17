package jpabook.start;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Getter
@Setter
@AllArgsConstructor
@Builder
@ToString
@EqualsAndHashCode
@Table(name = "MEMBER")
@Entity
public class MemberEntity {
    @Id
    @Column
    private String id;

    @Column(name="NAME")
    private String name;

    private Integer age;



}
