package com.company.magasin.MagasinExceptions;

public class VenteALaPieceException extends MagasinException{
    @Override
    public String getMessage() {
        return "L'article souhaité s'achète à la pièce. Veuillez rentrer un nombre entier pour la quantité.";
    }
}
