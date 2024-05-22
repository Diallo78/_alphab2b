package alpha.commerce.model;

import alpha.commerce.enums.OrderStatus;
import alpha.commerce.enums.OrderType;
import alpha.commerce.enums.PaymentMethode;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.*;

import java.time.LocalDate;
import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
@Builder
public class CommandeFournisseur extends AbstractEntity{
    private String code;

    private LocalDate dateOrderFournisseur;

    private OrderStatus orderStatus;
    private PaymentMethode paymentMethode;
    private OrderType orderType;
    private String businessCode;
    @ManyToOne
    @JoinColumn(name = "fournisseur_id")
    private Fournisseur fournisseur;

    @OneToMany(mappedBy = "cmdFournisseur")
    private List<CommandeFournisseurItem> ligneCommandeFournisseurs;
}
