package jpql.pagingAPI;

import lombok.*;

import javax.persistence.*;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder

@Entity
@Table(name = "PAGING_TEST")
public class JpqlPagingTest {
    @Id
    @GeneratedValue
    @Column(name = "PAGING_TEST_ID")
    private Long id;

    private String title;
    private String content;
}
