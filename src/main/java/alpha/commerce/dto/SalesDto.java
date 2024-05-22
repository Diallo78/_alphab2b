package alpha.commerce.dto;

import alpha.commerce.model.Sales;
import lombok.*;

import java.time.Instant;
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode @ToString
public class SalesDto {
    private Long id;
    private String code;
    private Instant dateSales;
    private String comment; // commantaire

    public static SalesDto formEntity(Sales sales){
        if (sales == null){
            return null;
        }

        return SalesDto.builder()
                .id(sales.getId())
                .code(sales.getCode())
                .dateSales(sales.getDateSales())
                .comment(sales.getComment())
                .build();

    }

    public static Sales toEntity(SalesDto dto){
        if (dto == null){
            return null;
        }

        Sales sales = new Sales();
        sales.setId(dto.getId());
        sales.setCode(dto.getCode());
        sales.setDateSales(dto.getDateSales());
        sales.setComment(dto.getComment());

        return sales;
    }
}
