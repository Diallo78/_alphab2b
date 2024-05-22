package alpha.commerce.model;

import jakarta.persistence.*;
import lombok.*;
import java.util.List;

@Entity
@Getter @Setter @EqualsAndHashCode @ToString
@AllArgsConstructor @NoArgsConstructor @Builder
@Table(name = "category")
public class Category extends AbstractEntity{
    @Column(nullable = false)
    private String code;
    @Column(nullable = false)
    private String name;
    private String description;
    private String businessCode;
    @OneToMany(mappedBy = "category")
    private List<Article> articles;
}
