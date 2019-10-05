package com.company.personne;

import com.company.magasin.Magasin;
import com.company.personne.CBException.CodeCompteException;
import com.company.personne.CBException.CompteException;
import com.company.personne.CBException.DecouvertCompteException;
import com.company.personne.Personne;

public class CompteBanq {

    private int num;
    private static int numCB;
    //Le compte bancaire peut être possédé par une personne ou un magasin
    private Magasin magasin;
    private Personne client;
    private double solde;
    private double decouvertAutorise;
    private String code1;
    private String code2;


    public CompteBanq (String code1, String code2){
        // Par défaut le numéro du compte associé est incrémenté de 1 à chaque nouvelle création de compte
        numCB ++;
        this.num = numCB;
        this.code1 = code1;
        this.code2 = code2;
    }

    // Setters et Getters de la classe

    public int getNum (){
        return num;
    }

    public void setClient(Personne client) {
        this.client = client;
    }

    public void setMagasin(Magasin magasin) {
        this.magasin = magasin;
    }

    public Magasin getMagasin() {
        return magasin;
    }

    public Personne getClient (){
        return client;
    }

    public double getSolde (){
        return solde;
    }

    public double getDecouvertAutorise(){
        return decouvertAutorise;
    }


 // on pourrait aussi faire rentrer le code dynmiquement
    public void setSolde(double nouveauSolde, String codeRentre) throws CodeCompteException{
        if (codeRentre.equals(code1)){
            this.solde = nouveauSolde;
        }
        else {
            throw new CodeCompteException();
        }
    }

    public void setDecouvertAutorise(double nouveauDecouvertAutorise, String codeRentre) throws CodeCompteException{
        if (codeRentre.equals(code2)){
            this.decouvertAutorise = nouveauDecouvertAutorise;
        }
        else {
            throw new CodeCompteException();
        }
    }

    public void versement(double somme, String codeRentre) throws CodeCompteException{
        if (codeRentre.equals(code1)){
           solde += somme;
        }
        else{
            throw new CodeCompteException();
        }
    }

    public void retrait (double somme, String codeRentre) throws CompteException {
        // sinon ne fonctionne pas dans main avec entrée utilisateur. Because you are checking if the objects are equal, not if the object values are equal.
        if (codeRentre.equals(code1)){
            if(somme>solde){
                if(somme<=solde+decouvertAutorise){
                    solde -= somme;
                }
                else{
                    throw new DecouvertCompteException();
                }
            }
            else{
                solde -= somme;
            }
        }
        else{
            throw new CodeCompteException();
            }
    }
}

