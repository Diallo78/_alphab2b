package alpha.commerce.model;

import alpha.commerce.enums.OrderType;
import alpha.commerce.enums.PaymentMethode;
import alpha.commerce.enums.OrderStatus;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.List;
@Entity
@Getter @Setter @EqualsAndHashCode @ToString
@AllArgsConstructor @NoArgsConstructor @Builder
@Table(name = "commande")
public class Commande extends AbstractEntity{
    private String code;

    private LocalDate dateOrder;

    private OrderStatus orderStatus;
    private PaymentMethode paymentMethode;
    private OrderType orderType;

    @ManyToOne
    @JoinColumn(name = "client_id", nullable = false)
    private Client client; // plusieur commande appartient a un client

    @OneToMany(mappedBy = "commande")
    private List<CommandeItem> commandeItems; // all line commande client in commande
}
