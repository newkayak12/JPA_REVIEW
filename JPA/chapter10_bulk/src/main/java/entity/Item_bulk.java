package entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class Item_bulk {
    @Id
    @GeneratedValue
    @Column(name = "ITEM_BULK_ID")
    private Long id;

    private String itemBulkName;
    private int itemBulkPrice;
    private int itemBulkStock;

}
