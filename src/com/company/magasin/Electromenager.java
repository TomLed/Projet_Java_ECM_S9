package com.company.magasin;

public class Electromenager extends Article {

    public Electromenager (String nom, double prixInitial){
        // Les articles d'électroménager se vendent à la pièce
        super(nom,"Le futur s'installe chez vous", prixInitial, true);
    }


}
