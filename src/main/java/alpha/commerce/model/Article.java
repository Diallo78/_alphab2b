package alpha.commerce.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.*;

import java.math.BigDecimal;
@Entity
@Getter @Setter @EqualsAndHashCode(callSuper = true) @ToString
@AllArgsConstructor @NoArgsConstructor @Builder
@Table(name = "article")
public class Article extends AbstractEntity{

    @Column(nullable = false)
    private String code;
    @Column(nullable = false)
    private String nameProduct;
    private String description;
    private String detail;
    @Column(nullable = false)
    private BigDecimal unitPriceHt;
    private BigDecimal vatRate; // taux de tva
    private BigDecimal unitPriceTtc;
    private String image;

    private String businessCode; // attribut technique pour faciliter la recher

    @ManyToOne
    @JoinColumn(name = "category_id", nullable = false)
    private Category category;

    @ManyToOne
    @JoinColumn(name = "brand_id", nullable = false)
    private Brand brand; // marque

}
