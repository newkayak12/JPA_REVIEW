package dsl.entity;

import lombok.*;

import javax.persistence.*;
@ToString
@Setter
@Getter
@AllArgsConstructor
@Builder
@Entity(name = "MEMBER_QUERYDSL")
public class Member_queryDSL {
    @Id
    @GeneratedValue
    @Column(name = "MEMBER_QUERYDSL_ID")
    private Long id;

    @Column(name = "MEMBER_QUERYDSL_NAME")
    private String name;

    @ManyToOne
    @JoinColumn(name = "ITEM_QUERYDSL_ID")
    private Item_queryDSL item;

    @Column(name = "MEMBER_QUERYDSL_ROLE")
    @Enumerated(EnumType.STRING)
    private Role role;

    public Member_queryDSL(String name, Role role) {
        this.name = name;
        this.role = role;
    }

    public Member_queryDSL() {
    }
}
