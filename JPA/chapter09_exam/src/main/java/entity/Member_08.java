package entity;

import entity.baseEntity.BaseEntity_08;
import entity.valueType.Address_09;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

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
//    private String city;
//    private String street;
//    private String zipcode;
    @Embedded
    private Address_09 address09;
//    order
    @OneToMany(mappedBy = "member08")
    private List<Order_08> orders = new ArrayList<>();
}
