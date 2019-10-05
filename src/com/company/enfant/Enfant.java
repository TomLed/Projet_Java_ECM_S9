package com.company.enfant;

public class Enfant{
    protected String Nom;
    protected String Prenom;
    protected int anneeNaissance;
    protected char sexe;
    protected int deptNaissance;
    protected String Adresse;

    public Enfant(String Nom, String Prenom, int anneeNaissance, char sexe, int deptNaissance, String Adresse){
        this.Nom = Nom;
        this.Prenom = Prenom;
        this.anneeNaissance = anneeNaissance;
        this.sexe = sexe;
        this.deptNaissance = deptNaissance;
        this.Adresse = Adresse;
    }

    public String getNom() {
        return Nom;
    }

    public String getPrenom() {
        return Prenom;
    }

    public int getAnneeNaissance() {
        return anneeNaissance;
    }

    public char getSexe() {
        return sexe;
    }

    public int getDeptNaissance() {
        return deptNaissance;
    }

    public void setAdresse(String adresse) {
        Adresse = adresse;
    }

    public String getAdresse() {
        return Adresse;
    }

}
