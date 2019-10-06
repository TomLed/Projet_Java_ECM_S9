package com.company.personne.eleve;

public class Note{
    String matiere;
    double note;
    int creditsobtenus;
    boolean validation;

    public Note(String matiere, double note, int creditsobtenus){
        this.matiere = matiere;
        this.note = note;
        this.creditsobtenus = creditsobtenus;
        setValidation();
        this.validation = getValidation();
    }

    public double getNote() {
        return note;
    }

    public void setNote(int newnote){
        note = newnote;
    }

    public String getMatiere(){
        return matiere;
    }

    public void setMatiere(String matiere) {
        this.matiere = matiere;
    }

    public int getCreditsobtenus() {
        return creditsobtenus;
    }

    public void setCreditsobtenus(int creditsobtenus) {
        this.creditsobtenus = creditsobtenus;
    }

    public boolean getValidation(){
        return validation;
    }

    // Un élève ne valide une matière que si sa note est supérieure ou égale à 10
    public void setValidation() {
        if(this.note >= 10){
            validation = true;
        }
        else {
            validation = false;
        }
    }

    public void afficherNote(){
        System.out.println("Matiere: " + getMatiere() + ", Note: " + getNote() + ", Crédits Obtenus: " + getCreditsobtenus() + ", Validation ? : " + getValidation());
    }
}
