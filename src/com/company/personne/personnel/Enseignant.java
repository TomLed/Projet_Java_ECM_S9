package com.company.personne.personnel;

import com.company.personne.PersonneException.NumSecuException;
import com.company.personne.personnel.Personnel;
import org.w3c.dom.ls.LSOutput;

public class Enseignant extends Personnel {
    private String echelon;
    private boolean serviceRealise;
    private int tempsService;
    private int heuresSupplementaires;
    private int dechargeHeures;
    private int fixe;
    private static int fixeMDC;
    private static int fixePRAG;
    private static int fixePROF;
    private int prime;

    public Enseignant(String Nom, String Prenom, String NumSecu, String Adresse, String dateEntree, String echelon, boolean tempsPlein) throws NumSecuException {
        super(Nom, Prenom, NumSecu, Adresse, dateEntree, tempsPlein);
        this.echelon = echelon;
        if (echelon.equals("MDC"));
            tempsService = 192;
            setFixeMDC(1200);
            fixe = fixeMDC;
        if (echelon.equals("PRAG")){
            tempsService = 384;
            setFixePRAG(1200);
            fixe = fixePRAG;
        }
        if (echelon.equals("PROF")){
            tempsService = 96;
            setFixePROF(1200);
            fixe = fixePROF;
        }
    }

    public void setTempsTravail(int tempsTravail){
        this.tempsTravail = tempsTravail;
        if (tempsTravail > tempsService) {
            heuresSupplementaires = tempsTravail - tempsService;
        }
        if (tempsTravail < tempsService){
            dechargeHeures = tempsService - tempsTravail;
        }
    }

    public void setFixeMDC(int fixeMDC) {
        this.fixeMDC = fixeMDC;
    }

    public void setFixePRAG(int fixePRAG) {
        this.fixePRAG = fixePRAG;
    }

    public void setFixePROF(int fixePROF) {
        this.fixePROF = fixePROF;
    }
    public void setEchelon(String echelon) {
        this.echelon = echelon;
    }

    public int getDechargeHeures() {
        return dechargeHeures;
    }

    public int getHeuresSupplementaires() {
        return heuresSupplementaires;
    }

    private boolean serviceRealise(){
        if (tempsTravail == 0){
            System.out.println("Attention, le temps de travail de l'enseignant est nul. Pensez à le renseigner");
        }
        if (tempsTravail >= tempsService){
            serviceRealise = true;
        }
        return serviceRealise;
    }


    public double calculSalaire() {
        // Définition de la méthode abstraite de la classe Personnel
        salaire = fixe * (1 + (float)1 / tempsTravail * (heuresSupplementaires - dechargeHeures) * 0.25);
        // Pas sur du fonctionnement des décharges d'heure ???
        // On choisit arbitrairement un taux de majoration de 25% pour les heures supplémentaires
        if (serviceRealise() == true) {
            salaire += prime;
            // On décide arbitrairement que la prime (qui est la meme pour tous les enseignants) est de 300
        }
        return salaire;

    }
}
