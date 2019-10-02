package com.company.personne;

import com.company.magasin.Magasin;
import com.company.personne.Personne;

public class CompteBanq {

    private String num;
    private Personne client;
    private float solde;
    private float decouvertAutorise;
    private String code1;
    private String code2;


    public CompteBanq (String num, Personne client, String code1, String code2){
        this.num = num;
        this.client = client;
        this.code1 = code1;
        this.code2 = code2;
    }

    // Setters et Getters de la classe

    public String getNum (){
        return num;
    }

    public Personne getClient (){
        return client;
    }

    public float getSolde (){
        return solde;
    }

    public float getDecouvertAutorise(){
        return decouvertAutorise;
    }

    public String getCode1(){
        return code1;
    }

    public String getCode2(){
        return code2;
    }
 // on pourrait aussi faire rentrer le code dynmiquement
    public void setSolde(float nouveauSolde, String codeRentre){
        if (codeRentre == code1){
            this.solde = nouveauSolde;
        }
        else {
            System.out.println("Le code saisi est incorrect");
        }
    }
    public void setDecouvertAutorise(float nouveauDecouvertAutorise, String codeRentre){
        if (codeRentre == code2){
            this.decouvertAutorise = nouveauDecouvertAutorise;
        }
        else {
            System.out.println("Le code saisi est incorrect");
        }
    }

    public void versement(int somme, String codeRentre){
        if (codeRentre.equals(code1)){
           solde += somme;
        }
        else{
            System.out.println("Le code saisi est incorrect");
        }
    }

    public void retrait (int somme, String codeRentre){
        // sinon ne fonctionne pas dans main avec entrée utilisateur. Because you are checking if the objects are equal, not if the object values are equal.
        if (codeRentre.equals(code1)){
            if(somme>solde){
                System.out.println("Attention ! Vous souhaitez retirer une somme supérieure au solde de votre compte, ");
                if(somme<=solde+decouvertAutorise){
                    System.out.println("cependant votre découvert autorisé vous permez le retrait de la somme désirée");
                    solde -= somme;
                }
                else{
                    System.out.println("de plus vous excédez votre découvert autorisé. Le retrait est impossible !");
                }
            }
            else{
                solde -= somme;
            }
        }
        else{
            System.out.println("Le code saisi est incorrect");
            }
    }
}

