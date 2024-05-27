package alpha.commerce.dto;

import alpha.commerce.enums.TypeMvtStk;
import alpha.commerce.model.MvtStk;
import lombok.*;

import java.math.BigDecimal;
import java.time.Instant;
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode @ToString
public class MvtStkDto {
    private Long id;
    private String code;
    private Instant dateMvt;
    private BigDecimal quantity;
    private TypeMvtStk typeMvtStk;

    private ArticleDto article;
    private String businessCode;
    public static MvtStkDto fromEntity(MvtStk mvtStk){
        if (mvtStk == null){
            return null;
        }

        return MvtStkDto.builder()
                .id(mvtStk.getId())
                .code(mvtStk.getCode())
                .dateMvt(mvtStk.getDateMvt())
                .quantity(mvtStk.getQuantity())
                .typeMvtStk(mvtStk.getTypeMvtStk())
                .article(ArticleDto.formEntity(mvtStk.getArticle()))
                .build();
    }

    public static MvtStk toEntity(MvtStkDto dto){
        if (dto == null){
            return null;
        }

        MvtStk mvtStk = new MvtStk();
        mvtStk.setId(dto.getId());
        mvtStk.setCode(dto.getCode());
        mvtStk.setDateMvt(dto.getDateMvt());
        mvtStk.setQuantity(dto.getQuantity());
        mvtStk.setQuantity(dto.getQuantity());
        mvtStk.setTypeMvtStk(dto.getTypeMvtStk());
        mvtStk.setArticle(ArticleDto.toEntity(dto.getArticle()));

        return mvtStk;
    }
}
