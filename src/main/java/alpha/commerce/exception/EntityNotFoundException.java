package alpha.commerce.exception;

/*
    Context : Utiliser dans la recuperation des donnees dans la base
    Cas : Si les donnees n'existe on utilise cette class exception pour traiter les csa
    Logique : Entity -> Dto (Back-end -> Front-end)
 */

import lombok.Getter;

public class EntityNotFoundException extends RuntimeException{

    @Getter
    private ErrorCodes errorCodes;

    public EntityNotFoundException(String message){
        super(message);
    }
    // Exception message and cause
    public EntityNotFoundException(String message, Throwable cause){
        super(message, cause);
    }
    // Exception message, Cause and Code Errors
    public EntityNotFoundException(String message, Throwable cause, ErrorCodes errorCodes){
        super(message, cause);
        this.errorCodes = errorCodes;
    }
    // Exception message and errors code
    public EntityNotFoundException(String message, ErrorCodes errorCodes){
        super(message); this.errorCodes = errorCodes;
    }

}
