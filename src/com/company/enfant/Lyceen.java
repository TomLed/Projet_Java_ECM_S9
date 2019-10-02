package com.company.enfant;

public class Lyceen extends Enfant implements Scolaire{
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

    public void setPasseUnExamen() {
        // Au lycée on passe un examen en Terminale, la dernière classe, ou en 1ère, la classe moyenne
        passeUnExamen = (grand() || moyen());
    }

    public boolean petit(){
        return niveauLyceen.equals("2nde");
    }

    public boolean grand(){
        return niveauLyceen.equals("Terminale");
    }

    public boolean moyen(){
        return (!petit() && !grand());
    }

}
