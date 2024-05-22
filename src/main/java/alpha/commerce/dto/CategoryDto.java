package alpha.commerce.dto;

import alpha.commerce.model.Category;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import java.util.Set;
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode @ToString
public class CategoryDto {
    private Long id;
    private String code;
    private String name;
    private String description;
    private String businessCode;
    @JsonIgnore
    private Set<ArticleDto> articles;

    // MAPPING ENTITY Category -> CategoryDto
    public static CategoryDto fromEntity(Category category){
        if (category == null){
            return null;
            // TODO Throw an exception
        }
        return CategoryDto.builder()
                .id(category.getId())
                .code(category.getCode())
                .name(category.getName())
                .description(category.getDescription())
                .businessCode(category.getBusinessCode())
                .build();
    }

    // MAPPING ENTITY CategoryDto -> Category
    public static Category toEntity(CategoryDto categoryDto){
        if (categoryDto == null){
            return null;
            // TODO Throw an exception
        }

        Category category = new Category();
        category.setId(categoryDto.getId());
        category.setCode(categoryDto.getCode());
        category.setName(categoryDto.getName());
        category.setDescription(categoryDto.getDescription());
        category.setBusinessCode(categoryDto.getBusinessCode());
        return category;
    }

}
