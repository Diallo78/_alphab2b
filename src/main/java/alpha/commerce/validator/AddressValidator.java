package alpha.commerce.validator;

import alpha.commerce.dto.AddressDto;

import java.util.ArrayList;
import java.util.List;

public class AddressValidator {

    public static List<String> validateAddress(AddressDto address) {
        List<String> errors = new ArrayList<>();

        if (address == null){
            errors.add("Le champ `country` est obligatoire.");
            errors.add("Le champ `country` est invalid.");
            errors.add("Le champ `city` est obligatoire.");
            errors.add("Le champ `address1` est obligatoire.");
            errors.add("Le champ `e-mail` est invalid.");

        }else {

            // Validation de `country`
            if (address.getCountry() == null || address.getCountry().isBlank()) {
                errors.add("Le champ `country` est obligatoire.");
            }

            if (!MyValidator.isValidLetters(address.getCountry())){
                errors.add("Le champ `country` est invalid.");
            }

            // Validation de `city`
            if (address.getCity() == null || address.getCity().isBlank()) {
                errors.add("Le champ `city` est obligatoire.");
            }

            // Validation de `postcode`
            if (address.getPostcode() == null || address.getPostcode().isBlank()) {
                errors.add("Le champ `postcode` est obligatoire.");
            }

            // Validation de `address1`
            if (address.getAddress1() == null || address.getAddress1().isBlank()) {
                errors.add("Le champ `address1` est obligatoire.");
            }

            if (address.getEmail() == null || address.getEmail().isBlank()){
                errors.add("Le champ `e-mail` est obligatoire.");
            }

            if (!MyValidator.isValidEmail(address.getEmail())) {
                errors.add("Le champ `e-mail` est invalid.");
            }

            if(address.getPhone() == null || address.getPhone().isBlank()){
                errors.add("Le champ `number phone` est obligatoire.");
            }

            if (!MyValidator.isValidPhoneFormat(address.getPhone())){
                errors.add("Le champ `number phone` est invalid.");
            }
        }

        return errors;
    }

}
