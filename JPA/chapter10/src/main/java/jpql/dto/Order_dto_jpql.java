package jpql.dto;

import jpql.entity.Address_jpql;
import jpql.entity.Member_jpql2;
import jpql.entity.Product_jpql;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Setter
@Getter
@ToString
public class Order_dto_jpql {
    private Long id;
    private int orderAmount;

    Member_jpql2 member;

    private Product_jpql product;

    Address_jpql address;

    public Order_dto_jpql(Member_jpql2 member, Product_jpql product, Address_jpql address) {
        this.member = member;
        this.product = product;
        this.address = address;
    }
}
