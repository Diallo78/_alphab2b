package alpha.commerce.validator;

import alpha.commerce.dto.BrandDto;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

public class BrandValidator {

    public static List<String> validateBrand(BrandDto dto){

        List<String> errors = new ArrayList<>();
        if (dto == null){
            errors.add("L'objet Brand est null aucun champs n'est remplits");
        }
        else {

            if (!StringUtils.hasLength(dto.getNom()) || dto.getNom().isBlank()){
                errors.add("L'objet Brand est vide.");
            }
            if (dto.getNom().length() < 3) {
                errors.add("Le nom de la marque doit contenir au moins 3 caractère ");
            }
            if (dto.getNom().length() > 30) {
                errors.add("Le nom de la marque ne doit pas dépasser 30 caractères.");
            }
            if (!MyValidator.isValidLetters(dto.getNom())){
                errors.add("Le champ `Name Brand` doit contenir uniquement des lettre alpha.");
            }
        }

        return errors;
    }


}
