package entity.baseEntity;

import javax.persistence.MappedSuperclass;
import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder

@MappedSuperclass
public class BaseEntity_08 {
    private Date createdDate;
    private Date lastModifiedDate;
}
