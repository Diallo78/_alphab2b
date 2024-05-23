package alpha.commerce.dto;

import alpha.commerce.model.SalesLine;
import lombok.*;

import java.math.BigDecimal;
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode @ToString
public class SalesLineDto {
    private Long id;
    private String code;
    private Integer quantity;
    private BigDecimal unitPrinceHt;

    private SalesDto sales;
    private String businessCode;
    public static SalesLineDto fromEntity(SalesLine line){
        if (line == null){
            return null;
        }
        return SalesLineDto.builder()
                .id(line.getId())
                .code(line.getCode())
                .quantity(line.getQuantity())
                .unitPrinceHt(line.getUnitPrinceHt())
                .sales(SalesDto.formEntity(line.getSales()))
                .build();
    }

    public static SalesLine toEntity(SalesLineDto dto){
        if (dto == null){
            return null;
        }

        SalesLine line = new SalesLine();
        line.setId(dto.getId());
        line.setCode(dto.getCode());
        line.setQuantity(dto.getQuantity());
        line.setUnitPrinceHt(dto.getUnitPrinceHt());
        line.setSales(SalesDto.toEntity(dto.getSales()));

        return line;
    }
}
