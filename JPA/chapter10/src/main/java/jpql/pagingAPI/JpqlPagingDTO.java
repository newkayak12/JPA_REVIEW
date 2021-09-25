package jpql.pagingAPI;

import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@Builder
@ToString

public class JpqlPagingDTO {
    private Long id;
    private String title;
    private String content;

    public JpqlPagingDTO(Long id, String title, String content) {
        this.id = id;
        this.title = title;
        this.content = content;
    }
}
