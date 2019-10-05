package com.company.personne;

import com.company.personne.PersonneException.NumSecuException;

public class Personne {
    protected String Nom;
    protected String Prenom;
    protected String NumSecu;
    protected int anneeNaissance;
    protected char sexe;
    protected int deptNaissance;
    protected String Adresse;

    public Personne(String Nom, String Prenom){
        this.Nom = Nom;
        this.Prenom = Prenom;
    }


    public Personne (String Nom, String Prenom, String NumSecu, String Adresse) throws NumSecuException{
        if (NumSecu.length() == 13){
            this.Nom = Nom;
            this.Prenom = Prenom;
            this.Adresse = Adresse;
            this.NumSecu = NumSecu;
            this.anneeNaissance = anneeNaissance(NumSecu);
            this.sexe = sexe(NumSecu);
            this.deptNaissance = deptNaissance(NumSecu);
        }
        else{
            throw new NumSecuException();
        }

    }

    @Override
    // A améliorer pour afficher seulement ce qui est non nul
    public String toString(){
        return "Nom: " + this.Nom + ", Prénom: " + this.Prenom + ", Num Sécu: " + this.NumSecu + ", Année de Naissance : " + this.anneeNaissance + ", Sexe: " + this.sexe + ", Département de naissance: " + this.deptNaissance;
    }

    private int anneeNaissance (String NumSecu){
        int an_naissance = Integer.parseInt(NumSecu.substring(1,3));
        if(an_naissance<=19){
            anneeNaissance = 2000 + an_naissance;
        }
        else{
            anneeNaissance = 1900 + an_naissance;
        }
        return anneeNaissance;
    }

    private char sexe(String NumSecu) throws NumSecuException {
        if (NumSecu.substring(0,1).equals("1")){
            this.sexe = 'M';
        }
        else if (NumSecu.substring(0,1).equals("2")){
            this.sexe = 'F';
        }
        else{
            throw new NumSecuException();
            }
        return sexe;
    }

    private int deptNaissance (String NumSecu){
        deptNaissance = Integer.parseInt(NumSecu.substring(5,7));
        return deptNaissance;
    }

    public int calculAge(){
        // On suppose que personne n'a plus de 100 ans
       return 2019 - anneeNaissance;
    }


    // Getters et Setters de la classe

    public String getNom(){
        return Nom;
    }

    public void setNom(String nouveauNom){
        this.Nom = nouveauNom;
    }

    public String getPrenom (){
        return Prenom;
    }

    public void setPrenom (String nouveauPrenom){
        this.Prenom = nouveauPrenom;
    }

    public String getNumSecu (){
        return NumSecu;
    }

    public void setNumSecu (String nouveauNumSecu) throws NumSecuException{
        this.NumSecu = nouveauNumSecu;
        this.anneeNaissance = anneeNaissance(nouveauNumSecu);
        this.sexe = sexe(nouveauNumSecu);
        this.deptNaissance = deptNaissance(nouveauNumSecu);
    }

    public int getAnneeNaissance(){
        return anneeNaissance;
    }

    public int getDeptNaissance(){
        return deptNaissance;
    }

    public char getSexe (){
        return sexe;
    }
}
