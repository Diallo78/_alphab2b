package alpha.commerce.dto;

import alpha.commerce.model.Article;
import lombok.*;

import java.math.BigDecimal;

@Builder
@AllArgsConstructor @NoArgsConstructor
@Getter @Setter @EqualsAndHashCode @ToString
public class ArticleDto {
    private Long id;
    private String code;
    private String nameProduct;
    private String description;
    private String detail;
    private BigDecimal unitPriceHt;
    private BigDecimal vatRate; // taux de tva
    private BigDecimal unitPriceTtc;
    private CategoryDto category;
    private String image;
    private BrandDto brand; // marque
    private String businessCode;
    public static ArticleDto formEntity(Article article){

        if(article == null){
            return null;
            // TODO Throw Exception
        }
        return ArticleDto.builder()
                .id(article.getId())
                .code(article.getCode())
                .nameProduct(article.getNameProduct())
                .description(article.getDescription())
                .detail(article.getDetail())
                .category(CategoryDto.fromEntity(article.getCategory()))
                .unitPriceHt(article.getUnitPriceHt())
                .unitPriceTtc(article.getUnitPriceTtc())
                .vatRate(article.getVatRate())
                .image(article.getImage())
                .brand(BrandDto.fromEntity(article.getBrand()))
                .businessCode(article.getBusinessCode())
                .build();
    }

    public static Article toEntity(ArticleDto dto){
        if(dto == null){
            return null;
        }

        Article article = new Article();

        article.setId(dto.getId());
        article.setCode(dto.getCode());
        article.setNameProduct(dto.getNameProduct());
        article.setDescription(dto.getDescription());
        article.setDetail(dto.getDetail());
        article.setCategory(CategoryDto.toEntity(dto.getCategory()));
        article.setUnitPriceHt(dto.getUnitPriceHt());
        article.setUnitPriceTtc(dto.getUnitPriceTtc());
        article.setVatRate(dto.getVatRate());
        article.setImage(dto.getImage());
        article.setBrand(BrandDto.toEntity(dto.getBrand()));
        article.setBusinessCode(dto.getBusinessCode());
        return article;

    }
}
