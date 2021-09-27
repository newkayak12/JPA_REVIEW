package dsl;


import javax.persistence.*;

@Entity(name = "MEMBER_QUERYDSL")
public class Member_queryDSL {
    @Id
    @GeneratedValue
    @Column(name = "MEMBER_QUERYDSL_ID")
    private Long id;

    @Column(name = "MEMBER_QUERYDSL_NAME")
    private String name;

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
