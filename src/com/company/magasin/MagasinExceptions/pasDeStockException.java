package com.company.magasin.MagasinExceptions;

public class pasDeStockException extends MagasinException{
    @Override
    public String getMessage() {
        return "Il n'y a pas assez d'article en stock pour la quantité demandée";
    }
}
