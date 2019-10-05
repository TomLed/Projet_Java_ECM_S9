package com.company.enfant;

public class Collegien extends Enfant implements Scolaire{
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

    public void setPasseUnExamen() {
        // Au collège on ne passe un examen que quand on est en 3ème, la plus grande des classes
        passeUnExamen = grand();
    }

    public boolean isPasseUnExamen() {
        setPasseUnExamen();
        return passeUnExamen;
    }

    public boolean petit(){
        return niveauCollegien.equals("6ème");
    }

    public boolean grand(){
        return niveauCollegien.equals("3ème");
    }

    public boolean moyen(){
        return (!petit() && !grand());
    }
}

