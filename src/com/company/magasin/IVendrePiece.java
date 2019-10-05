package com.company.magasin;

import com.company.magasin.MagasinExceptions.MagasinException;
import com.company.personne.CBException.CompteException;
import com.company.personne.CompteBanq;

public interface IVendrePiece {
    //Vendre au kilo et à la pièce est équivalent donc on ne garde qu'une des interfaces
    void vendre(Article article, double quantite, CompteBanq cb_client, String code_client) throws MagasinException, CompteException;
    void rembourser(Article article, double quantite, CompteBanq cb_client, String code_client)throws MagasinException, CompteException;
}
