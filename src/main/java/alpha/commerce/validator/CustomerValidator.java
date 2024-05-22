package alpha.commerce.validator;

import alpha.commerce.dto.CustomerDto;
import org.springframework.util.StringUtils;

import java.time.LocalDate;
import java.time.Period;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

public class CustomerValidator {
    public static List<String> validateCustomer(CustomerDto customerDto){
        List<String> errors = new ArrayList<>();

        if (customerDto == null){
            errors.add("L'objet customer est vide.");
            errors.add("Last Name is mandatory.");
            errors.add("First Name is mandatory");
            errors.add("Password is mandatory.");
            errors.add("Date of birth is mandatory.");
            errors.add("Address is mandatory.");
            errors.add("Country is mandatory.");
            errors.add("City is mandatory.");
            errors.add("Number phone is mandatory.");

        } else{
            // ==================== GESTION LASTNAME =================
            if (!StringUtils.hasLength(customerDto.getLastName())){
                errors.add("Last Name is mandatory.");
            }

            if (customerDto.getLastName().length() < 2 ) {
                errors.add("Le nom doit contenir au moins 2 caractère alpha (Ex: Ly).");
            }

            if (customerDto.getLastName().length() > 30) {
                errors.add("Le nom de l'utilisaeur ne doit pas dépasser 30 caractères.");
            }
            // Validation de l'absence de chiffres dans le nom
            if (!Pattern.compile("^[a-zA-z]+$").matcher(customerDto.getLastName()).find()) {
                errors.add("Le nom ne doit contenir que des lettres.");
            }
            // ==================== GESTION FIRSTNAME =================

            if (!StringUtils.hasLength(customerDto.getFirstName())){
                errors.add("First Name is mandatory");
            }
            if (customerDto.getFirstName().length() < 3 ) {
                errors.add("Le prénom doit contenir au moins 3 caractère alpha (Ex: Aly).");
            }

            if (customerDto.getFirstName().length() > 50) {
                errors.add("Le prénom de l'utilisaeur ne doit pas dépasser 50 caractères.");
            }
            // Validation de l'absence de chiffres dans le nom
            if (!Pattern.compile("^[a-zA-z]+$").matcher(customerDto.getFirstName()).find()) {
                errors.add("Le prénom ne doit contenir que des lettres.");
            }

            // ==================== GESTION PASSWORD =================
            if (!StringUtils.hasLength(customerDto.getMdp())){
                errors.add("Password is mandatory.");
            }
            if (!Pattern.compile("^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@$!%*?&])[A-Za-z\\d@$!%*?&()-_+=]{8,}$")
                    .matcher(customerDto.getMdp()).matches()) {
                errors.add("Le mot de passe doit contenir au moins 8 caractères, une " +
                        "lettre majuscule, une lettre minuscule, un chiffre et un caractère spécial.");
            }

            // ==================== GESTION Date Naissance =================
            if (customerDto.getDateOfBirth() == null){
                errors.add("Date of birth is mandatory.");
            }
            else {
                LocalDate birthDate = customerDto.getDateOfBirth().atZone(ZoneId.systemDefault()).toLocalDate();
                LocalDate now = LocalDate.now();

                Period period = Period.between(birthDate, now);

                if (period.getYears() < 18) {
                    errors.add("Le customer doit avoir au moins 18 ans");
                }
            }

            // ==================== GESTION ADRESSE =================
            if (customerDto.getAddress() == null){
                errors.add("Address is mandatory.");
            }else {
                // ******** E-mail ********
                if(!StringUtils.hasLength(customerDto.getAddress().getEmail())){
                    errors.add("E-mail is mandatory.");
                }
                if (!Pattern.compile("^[a-zA-Z0-9.+_-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$").matcher(customerDto.getAddress().getEmail()).matches()){
                    errors.add("Le format de l'adresse email est invalide");
                }
                // ******** Address1 ********
                if (!StringUtils.hasLength(customerDto.getAddress().getAddress1())) {
                    errors.add("Address1 is mandatory.");
                }
                // ******** Country ********
                if (!StringUtils.hasLength(customerDto.getAddress().getCountry())) {
                    errors.add("Country is mandatory.");
                }
                // ******** City ********
                if (!StringUtils.hasLength(customerDto.getAddress().getCity())) {
                    errors.add("City is mandatory.");
                }
                // ******** Address1 ********
                if (!StringUtils.hasLength(customerDto.getAddress().getPhone())) {
                    errors.add("Number phone is mandatory.");
                }
                if (!Pattern.compile("[0-9\\-]").matcher(customerDto.getLastName()).find()) {
                    errors.add("Le numéro de téléphone doit être composé de chiffres et/ou de tirets (-).");
                }

            }

            /*
            // ==================== GESTION ADRESSE =================
            if (customerDto.getAddress() == null){
                errors.add("Address is mandatory.");
            }else {
                List<String> addressErrors = AddressValidator.validateAddress(customerDto.getAddress());
                errors.addAll(addressErrors);
            }
             */
        }

        return errors;
    }
}
