package com.company.personne.PersonneException;

public class NumSecuException extends Exception {
    public String getMessage() {
        return "Le numéro de sécurité sociale ne commence ni par 1 ni par 2, il y a sûrement une erreur";
    }
}
