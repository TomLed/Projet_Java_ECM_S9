package com.company.personne.eleve;

import com.company.personne.PersonneException.NumSecuException;

import java.util.ArrayList;

public class EleveDigital extends Eleve {
    private ArrayList<Note> notes;
    // permet de calculer la moyenne de l'étudiant sur le semestre
    private double moyenne;
    // permet de voir si l'étudiant valide son semestre
    private boolean valide;

    public EleveDigital(String Nom, String Prenom, String NumSecu, String Adresse, int ine, int promo, int annee) throws NumSecuException {
        super(Nom, Prenom, NumSecu, Adresse, ine, promo, annee);
        notes = new ArrayList<>();
    }

    public void ajoutNote(Note note){
        notes.add(note);
    }

    public void afficherNote(){
        for(Note elem: notes){
            elem.afficherNote();
        }
    }

    public double calculMoyenne(){
        double somme = 0;
        int c = 0;
        for(Note note: notes){
            somme += note.getNote();
            c++;
        }
        moyenne = somme / c;
        return moyenne;
    }

    public boolean isValide() {
        valide = moyenne >= 10;
        return valide;
    }
}
