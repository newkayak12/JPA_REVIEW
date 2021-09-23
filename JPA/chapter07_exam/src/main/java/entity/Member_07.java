package entity;

import entity.baseEntity.BaseEntity_07;
import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder

@Entity
public class Member_07 extends BaseEntity_07 {
    @Id
    @GeneratedValue
    @Column(name = "MEMBER_07_ID")
    private Long id;

    private String name;
    private String city;
    private String street;
    private String zipcode;

//    order
    @OneToMany(mappedBy = "member07")
    private List<Order_07> orders = new ArrayList<>();
}
