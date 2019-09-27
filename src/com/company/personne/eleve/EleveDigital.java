package com.company.personne.eleve;

import java.util.ArrayList;

public class EleveDigital extends Eleve {
    ArrayList<Note> notes;

    public EleveDigital(String Nom, String Prenom, String NumSecu, String Adresse, int ine, int promo, int annee){
        super(Nom, Prenom, NumSecu, Adresse, ine, promo, annee);
        ArrayList<Note> notes = new ArrayList<Note>();
    }

    private void ajoutNote(Note note){
        notes.add(note);
    }

    private void afficherNote(){
        for(Note elem: notes){
            elem.afficherNote();
        }
    }

}
