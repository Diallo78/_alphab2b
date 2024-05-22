package alpha.commerce.dto;

import alpha.commerce.model.CommandeFournisseurItem;
import lombok.*;

import java.math.BigDecimal;
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode @ToString
public class CommandeFournisseurItemDto {
    private Long id;
    private String code;
    private BigDecimal quantity;
    private BigDecimal unitPrince;

    private CommandeFournisseurDto cmdFournisseur;
    private ArticleDto article;

    public static CommandeFournisseurItemDto fromEntity(CommandeFournisseurItem item){
        if (item == null){
            return null;
        }
        return CommandeFournisseurItemDto.builder()
                .id(item.getId())
                .code(item.getCode())
                .quantity(item.getQuantity())
                .unitPrince(item.getUnitPrince())
                .cmdFournisseur(CommandeFournisseurDto.fromEntity(item.getCmdFournisseur()))
                .article(ArticleDto.formEntity(item.getArticle()))
                .build();
    }

    public static CommandeFournisseurItem toEntity(CommandeFournisseurItemDto dto){
        if (dto == null){
            return null;
        }

        CommandeFournisseurItem item = new CommandeFournisseurItem();
        item.setId(dto.getId());
        item.setCode(dto.getCode());
        item.setQuantity(dto.getQuantity());
        item.setUnitPrince(dto.getUnitPrince());
        item.setCmdFournisseur(CommandeFournisseurDto.toEntity(dto.getCmdFournisseur()));
        item.setArticle(ArticleDto.toEntity(dto.getArticle()));

        return item;
    }

}
