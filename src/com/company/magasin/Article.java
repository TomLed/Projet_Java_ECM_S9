package com.company.magasin;

public class Article implements IPublicite, ISolde{
    protected String slogan;
    protected String nom;
    protected int quantite;
    protected double prixInitial;
    protected double prixRemise;
    protected double taux;
    boolean venteALaPiece;
    boolean solde;

    public Article(String nom, int quantite, String slogan, double prixInitial, boolean venteALaPiece){
        this.nom = nom;
        this.quantite = quantite;
        this.slogan = slogan;
        this.prixInitial = prixInitial;
        this.prixRemise = prixInitial;
        solde = false;
        this.venteALaPiece = venteALaPiece;
    }

    public String getNom() {
        return nom;
    }

    public int getQuantite() {
        return quantite;
    }

    public void afficheSlogan() {
        System.out.println(slogan);
    }
// A chaque vente, il faut baisser la quantité relative à l'article

    public void retireQuantite(double quantiteVendue){
        quantite -= quantiteVendue;
    }

    public double getPrixInitial() {
        return prixInitial;
    }

    // Pour mettre en place des soldes

    public void ActiverSolde(boolean yesorno) {
        solde = yesorno;
    }

    // Il faut rentrer le taux en pourcentage
    public void setTaux(double nouveauTaux) {
        taux = nouveauTaux;
    }

    public double getTaux() {
        return taux;
    }

    public void setPrixRemise(){
        if(solde == true){
            prixRemise -= (double) taux/100 * prixRemise;
        }
    }

    public double getPrixRemise() {
        return prixRemise;
    }
}