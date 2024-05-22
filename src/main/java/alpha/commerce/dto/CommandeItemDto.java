package alpha.commerce.dto;

import alpha.commerce.model.CommandeItem;
import lombok.*;

import java.math.BigDecimal;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter @EqualsAndHashCode @ToString
public class CommandeItemDto {
    private Long id;
    private String code;
    private Integer quantity;
    private BigDecimal unitPriceHt;
    private BigDecimal totalPrice;
    private CommandeDto commande;
    private ArticleDto article;

    public static CommandeItemDto fromEntity(CommandeItem item){
        if (item == null){
            return null;
        }

        return CommandeItemDto.builder()
                .id(item.getId())
                .code(item.getCode())
                .quantity(item.getQuantity())
                .unitPriceHt(item.getUnitPriceHt())
                .totalPrice(item.getTotalPrice())
                .commande(CommandeDto.fromEntity(item.getCommande()))
                .article(ArticleDto.formEntity(item.getArticle()))
                .build();
    }

   public static CommandeItem toEntity(CommandeItemDto dto){
       if (dto == null){
           return null;
       }

       CommandeItem item = new CommandeItem();
       item.setId(dto.getId());
       item.setCode(dto.getCode());
       item.setQuantity(dto.getQuantity());
       item.setUnitPriceHt(dto.getUnitPriceHt());
       item.setTotalPrice(dto.getTotalPrice());
       item.setCommande(CommandeDto.toEntity(dto.getCommande()));
       item.setArticle(ArticleDto.toEntity(dto.getArticle()));

       return item;
   }
}
