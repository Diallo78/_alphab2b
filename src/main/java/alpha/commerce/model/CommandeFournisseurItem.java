package alpha.commerce.model;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.*;

import java.math.BigDecimal;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
@Builder
public class CommandeFournisseurItem extends AbstractEntity{
    private String code;
    private BigDecimal quantity;
    private BigDecimal unitPrince;

    @ManyToOne
    @JoinColumn(name = "fournisseur_id", nullable = false)
    private CommandeFournisseur cmdFournisseur;
    @ManyToOne
    @JoinColumn(name = "article_id", nullable = false)
    private Article article;

}
