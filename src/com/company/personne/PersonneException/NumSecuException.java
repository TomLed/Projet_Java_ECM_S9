package com.company.personne.PersonneException;

public class NumSecuException extends Exception {
    public String getMessage() {
        return "Le numéro de sécurité sociale saisi ne commence ni par 1 ni par 2, ou ne fait pas 13 caractères. Il y a une erreur";
    }
}
