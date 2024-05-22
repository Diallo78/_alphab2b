package alpha.commerce.model;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.*;

import java.math.BigDecimal;

@Entity
@Getter
@Setter
@EqualsAndHashCode(callSuper = true) @ToString
@AllArgsConstructor
@NoArgsConstructor @Builder
public class SalesLine extends AbstractEntity {
    private String code;
    private Integer quantity;
    private BigDecimal unitPrinceHt;
    private String businessCode;
    @ManyToOne
    @JoinColumn(name = "sales_id")
    private Sales sales;
}
