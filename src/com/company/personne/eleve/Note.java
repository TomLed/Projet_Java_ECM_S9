package com.company.personne.eleve;

public class Note{
    String matiere;
    int note;
    int creditsobtenus;
    boolean validation;

    public Note(String matiere, int note, int creditsobtenus, boolean validation){
        this.matiere = matiere;
        this.note = note;
        this.creditsobtenus = creditsobtenus;
        this.validation = validation;
    }

    public int getNote() {
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

    public void setValidation(boolean validation) {
        this.validation = validation;
    }

    public void afficherNote(){
        System.out.println("Matiere: " + getMatiere() + ", Note: " + getNote() + ", Crédits Obtenus: " + getCreditsobtenus() + ", Validation ? : " + getValidation());
    }
}
