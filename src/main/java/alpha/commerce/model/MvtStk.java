package alpha.commerce.model;

import alpha.commerce.enums.TypeMvtStk;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.*;

import java.math.BigDecimal;
import java.time.Instant;

@Entity
@AllArgsConstructor @NoArgsConstructor
@Getter @Setter @EqualsAndHashCode(callSuper = true)
@Builder
public class MvtStk extends AbstractEntity{
    private String code;
    private Instant dateMvt;
    private BigDecimal quantity;
    private TypeMvtStk typeMvtStk;

    @ManyToOne
    @JoinColumn(name = "article_id")
    private Article article;


}
