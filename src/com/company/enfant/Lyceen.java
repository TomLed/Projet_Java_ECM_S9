package com.company.enfant;

public class Lyceen extends Enfant{
    private static String niveauxClasses [] = {"2nde", "1ère", "Terminale"};
    private String niveauLyceen;
    boolean passeUnExamen;

    public Lyceen (String Nom, String Prenom, int anneeNaissance, char sexe, int deptNaissance, String Adresse, String niveauLyceen) {
        super(Nom, Prenom, anneeNaissance, sexe, deptNaissance, Adresse);
        this.niveauLyceen = niveauLyceen;
    }

    public String getNiveauLyceen() {
        return niveauLyceen;
    }

    public void setNiveauLyceen(String niveauLyceen) {
        this.niveauLyceen = niveauLyceen;
    }

    public boolean isPasseUnExamen() {
        return passeUnExamen;
    }

    public void setPasseUnExamen(boolean passeUnExamen) {
        this.passeUnExamen = passeUnExamen;
    }

}
