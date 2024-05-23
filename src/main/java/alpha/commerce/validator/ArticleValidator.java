package alpha.commerce.validator;

import alpha.commerce.dto.ArticleDto;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

public class ArticleValidator {

    public static List<String> validateArticle(ArticleDto dto){
        List<String> errors = new ArrayList<>();

        if (dto == null){
            errors.add("Veuillez renseigner le code de l'article.");
            errors.add("Veuillez renseigner le nom de l'article.");
            errors.add("Veuillez renseigner le prix unitaire HT de l'article.");
            errors.add("Veuillez renseigner le taux TVA de l'article.");
            errors.add("Veuillez renseigner le prix unitaire TTC de l'article.");
            errors.add("Veuillez selectionner une categorie.");
            errors.add("Veuillez selectionner une marque.");
        }
        else {
            if(!StringUtils.hasLength(dto.getCode())){
                errors.add("Veuillez renseigner le `code` de l'article.");
            }
            if(!StringUtils.hasLength(dto.getNameProduct())){
                errors.add("Veuillez renseigner le `nom`de l'article.");
            }
            if (!MyValidator.isValidLetters(dto.getNameProduct())){
                errors.add("Le champ `Name article` doit contenir uniquement des lettre alpha.");
            }
            if (dto.getUnitPriceHt() == null) {
                errors.add("Veuillez renseigner le `prix unitaire HT` de l'article.");
            }
            if (dto.getVatRate() == null) {
                errors.add("Veuillez renseigner le `taux TVA` de l'article.");
            }
            if (dto.getUnitPriceTtc() == null) {
                errors.add("Veuillez renseigner le `prix unitaire` TTC de l'article.");
            }
            if (dto.getCategory() == null) {
                errors.add("Veuillez selectionner une categorie.");
            }
            if (dto.getBrand() == null) {
                errors.add("Veuillez selectionner une marque.");
            }
        }

        return errors;
    }
}
