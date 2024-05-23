package alpha.commerce.exception;

import lombok.Getter;

import java.util.List;

/*
    Context : Utiliser dans CUD des donnees dans la base
    Cas : Si les donnees sont pas valid par les regles definit dans Validator on leve l'exception
    Logique : Dto -> Entity (Front-end -> Back-end)
 */
public class InvalidEntityException extends RuntimeException{
    
    @Getter
    private ErrorCodes errorCodes;
    @Getter
    private List<String> errors;
    public InvalidEntityException(String message){
        super(message);
    }
    // Exception message and cause
    public InvalidEntityException(String message, Throwable cause){
        super(message, cause);
    }
    // Exception message, Cause and Code Errors
    public InvalidEntityException(String message, Throwable cause, ErrorCodes errorCodes){
        super(message, cause);
        this.errorCodes = errorCodes;
    }
    // Exception message and errors code
    public InvalidEntityException(String message, ErrorCodes errorCodes){
        super(message); this.errorCodes = errorCodes;
    }
    //Exception message, Code errors and List Errors
    public InvalidEntityException(String message, ErrorCodes errorCodes, List<String> errors){
        super(message);
        this.errorCodes = errorCodes;
        this.errors = errors;
    }
}
