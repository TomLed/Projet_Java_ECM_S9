package com.company.magasin;

public class Primeur extends Article {

    public Primeur (String nom, int quantite, double prixInitial){
        // Les fruits et légumes se vendent au kilo
        super(nom, quantite, "Le goût primeur", prixInitial, false);
    }
}
