package dsl.entity;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Setter
@Getter
@ToString

public class Item_queryDSL_DTO {

    private String name;
    private String detail;
    private int price;


}
