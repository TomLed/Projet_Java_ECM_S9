package com.company.personne.CBException;

public class DecouvertCompteException extends CompteException {
    public String getMessage() {
        return "Vous excédez le découvert autorisé. Retrait impossible !";
    }
}
