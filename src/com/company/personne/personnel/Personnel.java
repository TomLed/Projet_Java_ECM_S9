package com.company.personne.personnel;

import com.company.personne.Personne;
import com.company.personne.PersonneException.NumSecuException;

public abstract class Personnel extends Personne {
    // La classe ne doit pas pouvoir avoir d'instance. Donc classe abstraite
    String dateEntree;
    protected int tempsTravail;
    protected int salaire;
    private boolean tempsPlein;

    public Personnel(String Nom, String Prenom, String NumSecu, String Adresse, String dateEntree, boolean tempsPlein) throws NumSecuException {
        super(Nom,Prenom,NumSecu,Adresse);
        this.dateEntree = dateEntree;
        this.tempsPlein = tempsPlein;
        if (tempsPlein){
            tempsTravail = 100;
        }
    }

    protected abstract double calculSalaire();
}
