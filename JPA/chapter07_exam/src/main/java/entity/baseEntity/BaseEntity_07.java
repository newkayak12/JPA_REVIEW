package entity.baseEntity;

import lombok.*;

import javax.persistence.MappedSuperclass;
import java.util.Date;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder

@MappedSuperclass
public class BaseEntity_07 {
    private Date createdDate;
    private Date lastModifiedDate;
}
