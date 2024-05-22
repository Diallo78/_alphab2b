package alpha.commerce.dto;

import alpha.commerce.enums.OrderStatus;
import alpha.commerce.enums.OrderType;
import alpha.commerce.enums.PaymentMethode;
import alpha.commerce.model.CommandeFournisseur;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import java.time.LocalDate;
import java.util.List;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode @ToString
public class CommandeFournisseurDto {
    private Long id;
    private String code;
    private LocalDate dateOrderFournisseur;
    private OrderStatus orderStatus;
    private PaymentMethode paymentMethode;
    private OrderType orderType;
    private FournisseurDto fournisseur;
    @JsonIgnore
    private List<CommandeFournisseurItemDto> ligneCommandeFournisseurs;

    public static CommandeFournisseurDto fromEntity(CommandeFournisseur fournisseur){
        if (fournisseur == null){
            return null;
        }
        return CommandeFournisseurDto.builder()
                .id(fournisseur.getId())
                .code(fournisseur.getCode())
                .dateOrderFournisseur(fournisseur.getDateOrderFournisseur())
                .orderStatus(fournisseur.getOrderStatus())
                .paymentMethode(fournisseur.getPaymentMethode())
                .orderType(fournisseur.getOrderType())
                .fournisseur(FournisseurDto.FromEntity(fournisseur.getFournisseur()))
                .build();
    }

    public static CommandeFournisseur toEntity(CommandeFournisseurDto dto){
        if (dto == null){
            return null;
        }
        CommandeFournisseur cmdFour = new CommandeFournisseur();
        cmdFour.setId(dto.getId());
        cmdFour.setCode(dto.getCode());
        cmdFour.setDateOrderFournisseur(dto.getDateOrderFournisseur());
        cmdFour.setOrderStatus(dto.getOrderStatus());
        cmdFour.setPaymentMethode(dto.getPaymentMethode());
        cmdFour.setOrderType(dto.getOrderType());
        cmdFour.setFournisseur(FournisseurDto.toEntity(dto.getFournisseur()));

        return cmdFour;
    }
}
