package com.company.enfant;

public class Ecolier extends Enfant {
    // Static car ce tableau est identique pour tous les objets instance de la classe
    private static String niveauxClasses [] = {"CP", "CE1", "CE2", "CM1", "CM2"};
    private String niveauEcolier;

    public Ecolier (String Nom, String Prenom, int anneeNaissance, char sexe, int deptNaissance, String Adresse, String niveauEcolier){
        super(Nom, Prenom, anneeNaissance, sexe, deptNaissance, Adresse);
        this.niveauEcolier = niveauEcolier;
    }

    public void setNiveauEcolier(String niveauEcolier) {
        this.niveauEcolier = niveauEcolier;
    }

    public String getNiveauEcolier() {
        return niveauEcolier;
    }
}
