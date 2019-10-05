package com.company.personne.CBException;

public class CodeCompteException extends CompteException {
    public String getMessage() {
        return "Le code saisi est incorrect";
    }
}
