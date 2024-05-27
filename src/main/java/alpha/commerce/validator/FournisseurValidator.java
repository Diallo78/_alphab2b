package alpha.commerce.validator;

import alpha.commerce.dto.FournisseurDto;

import java.util.ArrayList;
import java.util.List;

public class FournisseurValidator {

    public static List<String> validateFournisseur(FournisseurDto dto){
        List<String> errors = new ArrayList<>();
        if (dto == null){
            errors.add("Le champ `code` est obligatoire.");
            errors.add("Le champ `Last Name` est obligatoire.");
            errors.add("Le champ `First Name` est obligatoire.");
            errors.add("Le champ `Code Business` est obligatoire.");
        }
        if (dto.getAddress() == null){
            errors.add("Address is mandatory.");
        }else {
            List<String> addressErrors = AddressValidator.validateAddress(dto.getAddress());
            errors.addAll(addressErrors);
        }
        return errors;
    }

}
