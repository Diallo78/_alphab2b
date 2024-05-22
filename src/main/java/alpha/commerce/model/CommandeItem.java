package alpha.commerce.model;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.DecimalMax;
import jakarta.validation.constraints.DecimalMin;
import lombok.*;

import java.math.BigDecimal;

@Entity
@Getter @Setter @EqualsAndHashCode @ToString
@AllArgsConstructor @NoArgsConstructor @Builder
@Table(name = "commandeItem")
public class CommandeItem extends AbstractEntity{
    private String code;
    private Integer quantity;
    private BigDecimal unitPriceHt;
    private BigDecimal totalPrice;
    private String businessCode;
    @ManyToOne
    @JoinColumn(name = "commande_id", nullable = false)
    private Commande commande;

    @ManyToOne
    @JoinColumn(name = "article_id", nullable = false)
    private Article article;

}
