package com.company.magasin;

public class Electromenager extends Article {

    public Electromenager (String nom, int quantite, double prixInitial){
        // Les articles d'électroménager se vendent à la pièce
        super(nom, quantite, "Le futur s'installe chez vous", prixInitial, true);
    }


}
