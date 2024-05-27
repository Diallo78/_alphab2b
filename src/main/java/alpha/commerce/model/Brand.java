package alpha.commerce.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.util.Set;

@Entity
@Getter @Setter @EqualsAndHashCode(callSuper = true)
@ToString @AllArgsConstructor @NoArgsConstructor @Builder
@Table(name = "brand")
public class Brand extends AbstractEntity{

    @Column(nullable = false)
    private String nom; // Brand(Marque) name
    private String businessCode;
    @OneToMany(mappedBy = "brand")
    private Set<Article> articles;
}
