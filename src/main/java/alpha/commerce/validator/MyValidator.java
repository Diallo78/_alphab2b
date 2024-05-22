package alpha.commerce.validator;


public class MyValidator {
    /*
       Context :
            1 - value == null: Cette condition vérifie si la chaîne est nulle.
            Une chaîne nulle est considérée comme vide.
            2 - value.trim().isEmpty():
                * value.trim(): Cette méthode supprime les espaces blancs de début et de fin de la chaîne.
                *.isEmpty(): Cette méthode (introduite en Java 7) vérifie si la chaîne résultante après
                  suppression des espaces est vide.

       Params : Cette fonction prend une chaîne de caractères value en paramètre.
       Returns : renvoie true si la chaîne est vide, et false sinon.
     */
    public static boolean isEmpty(String value) {
        return value == null || value.trim().isEmpty();
    }

    /*
        Context : En plus de la vérification des chiffres, elle vérifie également si la valeur fournie est nulle.
        Params : Cette fonction prend une chaîne de caractères value en paramètre.
        Returns : Renvoie true si la chaîne ne contient que des chiffres, et false sinon
     */
    public static boolean containsOnlyNumbers(String value) {
        return value != null && value.matches("^[0-9]+$");
    }

    /*
         Params : Cette fonction prend une chaîne de caractères value en paramètre.
         Returns : Renvoie true si la chaîne ne contient que des lettres (minuscules et majuscules)
         et des caractères accentués de l'alphabet latin de base, et false sinon.
     */
    public static boolean isValidLetters(String value) {
        return value.matches("[A-Za-zÀ-Öà-ö]+$");
    }

    /*
        Context : Cette validation n'autorise que les chiffres de 0 à 9.
        Params : Cette fonction prend une chaîne de caractères value en paramètre
        Returns : Renvoie true si la chaîne ne contient que des chiffres, et false sinon.
     */
    public static boolean isValidDigits(String value) {
        // Expression régulière pour les chiffres uniquement
        return value.matches("[0-9]+$");
    }

    /*
        Context : La fonction isValidPhoneFormat est une fonction Java qui vérifie si un numéro de téléphone donné
        est dans un format valide
        Params : Cette fonction prend une chaîne de caractères phone en paramètre
        Returns : Renvoie true si le format du numéro de téléphone est valide selon l'expression régulière fournie, et false sinon.
     */
    public static boolean isValidPhoneFormat(String phone) {
        return phone.matches("^\\+(?:[0-9]+\\s?)*[-,]?(?:[0-9]+\\s?)*$|^\\d{3}(?:[- ]?\\d{3}){2}$");
    }

    /*
        Params : Cette fonction prend une chaîne de caractères email en paramètre
        Returns : Renvoie true si l'email est valide selon une expression régulière basique, et false sinon.
     */
    public static boolean isValidEmail(String email) {
        // Expression régulière basique pour la validation d'email
        return email.matches("^[\\w!#$%&'*+/=?^`{|}~-]+(?:\\.[\\w!#$%&'*+/=?^`{|}~-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,}$");
    }

}

