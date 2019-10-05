package com.company.magasin.MagasinExceptions;

public class mineurException extends MagasinException {
    @Override
    public String getMessage() {
        return "Le client est mineur et ne peut acheter d'alcool";
    }
}
