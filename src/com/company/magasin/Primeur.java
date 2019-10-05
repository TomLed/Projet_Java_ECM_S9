package com.company.magasin;

public class Primeur extends Article {

    public Primeur (String nom, double prixInitial){
        // Les fruits et légumes se vendent au kilo
        super(nom, "Le goût primeur", prixInitial, false);
    }
}
