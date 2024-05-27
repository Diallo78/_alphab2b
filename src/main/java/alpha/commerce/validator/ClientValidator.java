package alpha.commerce.validator;

import alpha.commerce.dto.ClientDto;

import java.util.ArrayList;
import java.util.List;

public class ClientValidator {

    public static List<String> validateClient(ClientDto dto){
        List<String> errors = new ArrayList<>();
        if (dto == null){
            errors.add("Le champ `code` est obligatoire.");
            errors.add("Le champ `Last Name` est obligatoire.");
            errors.add("Le champ `First Name` est obligatoire.");
            errors.add("Le champ `Code Business` est obligatoire.");
        }else {
            // code
            if (!MyValidator.isEmpty(dto.getCode())){
                errors.add("Le champ `code` est obligatoire.");
            }

            if (dto.getBusinessCode() == null){
                errors.add("Le champ `Code Business` est obligatoire.");
            }
            // lastName
            if (!MyValidator.isValidEmail(dto.getLastName())){
                errors.add("Le champ `Last Name` est obligatoire.");
            }
            else {
                if (!MyValidator.isValidLetters(dto.getLastName())){
                    errors.add("Le champ `Last Name` doit contenir uniquement des lettre alpha.");
                }
                if (dto.getLastName().length() < 2){
                    errors.add("Le `Last Name` doit contenir au moins 2 caractère alpha (Ex: Ly).");
                } if (dto.getLastName().length() > 30) {
                    errors.add("Le `Last Name` de l'utilisaeur ne doit pas dépasser 30 caractères.");
                }
            }

            // firstName
            if (!MyValidator.isValidEmail(dto.getFirstName())){
                errors.add("Le champ `First Name` est obligatoire.");
            }
            else {
                if (!MyValidator.isValidLetters(dto.getFirstName())){
                    errors.add("Le champ `First Name` doit contenir uniquement des lettre alpha.");
                }
                if (dto.getFirstName().length() < 3){
                    errors.add("Le `First Name` doit contenir au moins 2 caractère alpha (Ex: Ly).");
                } if (dto.getLastName().length() > 30) {
                    errors.add("Le `First Name` de l'utilisaeur ne doit pas dépasser 30 caractères.");
                }
            }

            // Address
            if (dto.getAddress() == null){
                errors.add("Address is mandatory.");
            }else {
                List<String> addressErrors = AddressValidator.validateAddress(dto.getAddress());
                errors.addAll(addressErrors);
            }

        }
        return errors;
    }
}
