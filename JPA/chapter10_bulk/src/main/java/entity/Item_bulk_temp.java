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
public class Item_bulk_temp {
    @Id
    @Column(name = "ITEM_BULK_TEMP_ID")
    private Long id;

    private String itemBulkTempName;
    private int itemBulkTempPrice;
    private int itemBulkTempStock;

}
