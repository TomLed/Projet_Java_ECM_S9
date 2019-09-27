package com.company.personne.eleve;

import com.company.personne.Personne;

public class Eleve extends Personne {
    int ine;
    int promo;
    int annee;

    public Eleve (String Nom, String Prenom, String NumSecu, String Adresse, int ine, int promo, int annee) {
        super(Nom, Prenom, NumSecu, Adresse);
        this.ine = ine;
        this.promo = promo;
        this.annee = annee;
    }
}