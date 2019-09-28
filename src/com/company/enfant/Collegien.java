package com.company.enfant;

public class Collegien extends Enfant{
    private static String niveauxClasses [] = {"6ème", "5ème", "4ème", "3ème"};
    private String niveauCollegien;
    boolean passeUnExamen;

    public Collegien (String Nom, String Prenom, int anneeNaissance, char sexe, int deptNaissance, String Adresse, String niveauCollegien) {
        super(Nom, Prenom, anneeNaissance, sexe, deptNaissance, Adresse);
        this.niveauCollegien = niveauCollegien;
    }

    public String getNiveauCollegien() {
        return niveauCollegien;
    }

    public void setNiveauCollegien(String niveauCollegien) {
        this.niveauCollegien = niveauCollegien;
    }

    public void setPasseUnExamen(boolean passeUnExamen) {
        this.passeUnExamen = passeUnExamen;
    }

    public boolean isPasseUnExamen() {
        return passeUnExamen;
    }
}

