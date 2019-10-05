package com.company.personne.personnel;

import com.company.personne.PersonneException.NumSecuException;
import com.company.personne.personnel.Personnel;

public class IATOS extends Personnel {
    private int heuresSupplementaires;
    private int fixe;

    public IATOS (String Nom, String Prenom, String NumSecu, String Adresse, String dateEntree, int heuresSupplementaires, boolean tempsPlein) throws NumSecuException {
        super(Nom, Prenom, NumSecu, Adresse, dateEntree, tempsPlein);
        this.heuresSupplementaires = heuresSupplementaires;
    }

    public void setHeuresSupplementaires(int heuresSupplementaires) {
        this.heuresSupplementaires = heuresSupplementaires;
    }

    public int getHeuresSupplementaires() {
        return heuresSupplementaires;
    }

    public void setFixe(int fixe) {
        this.fixe = fixe;
    }

    protected double calculSalaire(){
        return salaire = fixe * (1 + 1/100 * (25/100) * heuresSupplementaires);
        // On suppose que le temps de travail d'un IATOS est de 100h
        // On choisit arbitrairement un taux de majoration de 25% pour les heures supplémentaires
    }
}
