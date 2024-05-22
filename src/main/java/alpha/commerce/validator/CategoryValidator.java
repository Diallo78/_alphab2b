package alpha.commerce.validator;

import alpha.commerce.dto.CategoryDto;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

public class CategoryValidator {
    public static List<String> validateCategory(CategoryDto categoryDto){
        List<String> errors = new ArrayList<>();

        if (categoryDto != null){

            if (StringUtils.hasLength(categoryDto.getName())){
                if (categoryDto.getName().length() < 3) {
                    errors.add("Le nom de la catégorie doit contenir au moins 3 caractères");
                }

                // Validation de la longueur maximale du nom
                if (categoryDto.getName().length() > 50) {
                    errors.add("Le nom de la catégorie ne doit pas dépasser 50 caractères");
                }

                // Validation de l'absence de chiffres dans le nom
                if (Pattern.compile("[0-9]").matcher(categoryDto.getName()).find()) {
                    errors.add("Le nom de la catégorie ne doit pas contenir de chiffres");
                }
            } else if (!StringUtils.hasLength(categoryDto.getName())) {
                errors.add("Veuillez renseigner le name de la categorie");
            } else if (!StringUtils.hasLength(categoryDto.getCode())) {
                errors.add("Veuillez renseigner le code de la categorie");
            }
        } else{errors.add("L'objet category est vide");}

        return errors;
    }
}
