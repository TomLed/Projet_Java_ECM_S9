package com.company.magasin.MagasinExceptions;

public class ageException extends MagasinException {
    @Override
    public String getMessage() {
        return "Le client a moins de 10 ans. Il n'est pas autorisé à faire des achats dans ce magasin";
    }
}
