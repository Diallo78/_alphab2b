package alpha.commerce.validator;

import alpha.commerce.dto.BusinessDto;

import java.util.ArrayList;
import java.util.List;

public class BusinessValidator {

    public static List<String> validate(BusinessDto dto){
        List<String> errors = new ArrayList<>();
        if (dto == null){

        }else {
            if (dto.getAddress() == null) {
                errors.add("Le champ `address` est obligatoire.");
            }else {
                List<String> addressErrors = AddressValidator.validateAddress(dto.getAddress());
                errors.addAll(addressErrors);
            }
        }
        return errors;
    }

}
