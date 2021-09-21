package manyToMany.biDirection;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder

@Entity
public class BuyerBiDirection {
    @Id
    @Column(name = "BUYERBIDIRECTION_ID")
    private String id;

    private String userName;

    @ManyToMany
    @JoinTable(name = "BUYER_PRODUCT_BIDIRECTION", joinColumns =  @JoinColumn(name = "BUYERBIDIRECTION_ID"), inverseJoinColumns = @JoinColumn(name = "PRODUCTBIDIRECTION_ID"))
    private List<ProductBiDirection> products = new ArrayList<>();
//ManyToMany와 JoinTable을 통해서 바로 매핑했다.
/*
    @JoinTable
        - name : 연결 테이블을 지정
        - joinColumns : BUYER와 매핑할 조인 컬럼 정보를 지정
        - inverseJoinColumn : 이어진 테이블의 반대 방향인 상품과 매핑할 조인 컬럼 정보를 지정


        여기서 MEMBER_PRODUCT_ONEWAY는 N:N을 N:1 + 1:N으로 풀어내기 위한 테이블일 뿌닝다.
 */

    public BuyerBiDirection(String id, String userName) {
        this.id = id;
        this.userName = userName;
    }

    public void addProduct(ProductBiDirection product){
        products.add(product);
        product.getBuyerBiDirections().add(this);
    }
}
