package com.company.magasin;

import com.company.personne.CompteBanq;

import java.util.ArrayList;

public class Magasin implements IVendrePiece, IVendreKilo{
    private String nom;
    private String adresse;
    private int nbVendeurs;
    private ArrayList<Article> listeStock;
    // Pour l'instant on considère la caisse comme une valeur de type double qui correpsond à l'argent qu'elle contient
    private double caisse;

    public Magasin(String nom, String adresse, int nbVendeurs){
        // On fait commencer le magasin avec une caisse vide
        caisse = 0;
        this.nom = nom;
        this.adresse = adresse;
        this.nbVendeurs = nbVendeurs;
        listeStock = new ArrayList<Article>();
    }

    // Le magasin peut licencier ou engager de nouveaux vendeurs
    public void setNbVendeurs(int nbVendeurs) {
        this.nbVendeurs = nbVendeurs;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    // Le magasin peut ajouter des articles à son stock

    public void ajouterArticle(Article a){
        listeStock.add(a);
    }
}
