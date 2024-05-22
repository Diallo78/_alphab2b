package alpha.commerce.validator;

import alpha.commerce.dto.BrandDto;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

public class BrandValidator {

    public static List<String> validateBrand(BrandDto dto){

        List<String> errors = new ArrayList<>();
        if (dto == null){
            errors.add("L'objet Business est null aucun champs n'est remplits");
            return errors;
        }else {
            if (!StringUtils.hasLength(dto.getNom())){
                errors.add("L'objet customer est vide.");
            } else if (dto.getNom().length() < 3) {
                errors.add("Le nom de la marque doit contenir au moins 3 caractère ");
            } else if (dto.getNom().length() > 30) {
                errors.add("Le nom de la marque ne doit pas dépasser 30 caractères.");
            }
        }
        return errors;
    }


}
