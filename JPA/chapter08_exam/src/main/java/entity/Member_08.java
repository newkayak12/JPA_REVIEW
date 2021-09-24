package entity;

import entity.baseEntity.BaseEntity_08;
import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

@Entity
public class Member_08 extends BaseEntity_08 {
    @Id
    @GeneratedValue
    @Column(name = "MEMBER_08_ID")
    private Long id;

    private String name;
    private String city;
    private String street;
    private String zipcode;

//    order
    @OneToMany(mappedBy = "member08")
    private List<Order_08> orders = new ArrayList<>();
}
