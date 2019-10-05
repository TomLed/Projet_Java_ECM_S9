package com.company.personne.eleve;

import com.company.personne.PersonneException.NumSecuException;

import java.util.ArrayList;

public class EleveDigital extends Eleve {
    private ArrayList<Note> notes;

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

}
