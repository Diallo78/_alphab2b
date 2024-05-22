package alpha.commerce.dto;

import alpha.commerce.enums.OrderStatus;
import alpha.commerce.enums.OrderType;
import alpha.commerce.enums.PaymentMethode;
import alpha.commerce.model.Commande;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import java.time.LocalDate;
import java.util.List;
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter @EqualsAndHashCode @ToString
public class CommandeDto {
    private Long id;
    private String code;
    private LocalDate dateOrder;

    private OrderStatus orderStatus;
    private PaymentMethode paymentMethode;
    private OrderType orderType;

    private ClientDto client;
    @JsonIgnore
    private List<CommandeItemDto> commandeItems;

    public static CommandeDto fromEntity(Commande commande){
        if (commande == null){
            return null;
        }

        return CommandeDto.builder()
                .id(commande.getId())
                .code(commande.getCode())
                .dateOrder(commande.getDateOrder())
                .orderStatus(commande.getOrderStatus())
                .paymentMethode(commande.getPaymentMethode())
                .orderType(commande.getOrderType())
                .client(ClientDto.fromEntity(commande.getClient()))
                .build();
    }

    public static Commande toEntity(CommandeDto dto){
        if (dto == null){
            return null;
        }

        Commande commande = new Commande();
        commande.setId(dto.getId());
        commande.setCode(dto.getCode());
        commande.setDateOrder(dto.getDateOrder());
        commande.setOrderStatus(dto.getOrderStatus());
        commande.setPaymentMethode(dto.getPaymentMethode());
        commande.setOrderType(dto.getOrderType());
        commande.setClient(ClientDto.toEntity(dto.getClient()));
        return commande;
    }
}
