package alpha.commerce.dto;

import alpha.commerce.model.Brand;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import java.util.Set;
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode @ToString
public class BrandDto {
    private Long id;
    private String nom; // Brand(Marque) name
    private String businessCode;
    @JsonIgnore
    private Set<ArticleDto> articles;

    public static BrandDto fromEntity(Brand brand){
        if (brand == null){
            return null;
        }

        return
                BrandDto.builder()
                        .id(brand.getId())
                        .nom(brand.getNom())
                        .businessCode(brand.getBusinessCode())
                        .build();
    }

    public static Brand toEntity(BrandDto brandDto){
        if (brandDto == null){
            return null;
        }

        Brand brand = new Brand();
        brand.setId(brandDto.getId());
        brand.setNom(brandDto.getNom());
        brand.setBusinessCode(brandDto.getBusinessCode());

        return brand;
    }
}
