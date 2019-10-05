package com.company.magasin;

import com.company.magasin.MagasinExceptions.MagasinException;
import com.company.magasin.MagasinExceptions.VenteALaPieceException;
import com.company.magasin.MagasinExceptions.pasDeStockException;
import com.company.personne.CBException.CodeCompteException;
import com.company.personne.CBException.CompteException;
import com.company.personne.CBException.DecouvertCompteException;
import com.company.personne.CompteBanq;

import java.security.cert.CertificateParsingException;
import java.util.ArrayList;

public class Magasin implements IVendrePiece{
    private String nom;
    private String adresse;
    private int nbVendeurs;
    private ArrayList<Article> listeStock;
    // Pour l'instant on considère la caisse comme une valeur de type double qui correpsond à l'argent qu'elle contient
    public CompteBanq CB;
    // Les codes pour le compte bancaire du magasin
    private String code1;
    private String code2;

    public Magasin(String nom, String adresse, int nbVendeurs, String code1, String code2){
        // On fait commencer le magasin avec une caisse vide
        this.nom = nom;
        this.adresse = adresse;
        this.nbVendeurs = nbVendeurs;
        listeStock = new ArrayList<>();
        this.code1 = code1;
        this.code2 = code2;
        CB = new CompteBanq(code1,code2);
        CB.setMagasin(this);
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    // Le magasin peut licencier ou engager de nouveaux vendeurs
    public void setNbVendeurs(int nbVendeurs) {
        this.nbVendeurs = nbVendeurs;
    }

    // On peut donner de l'argent au magasin pour démarrer le commerce

    public void ajouterDuCapital(double somme) throws CompteException{
        try {
            CB.versement(somme, code1);
        }
        catch (CompteException e){
            throw e;
        }
    }

    // Un magasin peut acheter des articles pour les ajouter à son stock
    // On considère qu'il peut achèter les articles 25% moins chers que le prix de base
    // Mettre exception si article pièce et quantité pas entier
    public void acheterArticle(Article a, double quantite)throws CompteException {
        a.setTaux(25);
        try{
            CB.retrait(a.getPrixRemise()*quantite, code1);
            a.setQuantite(quantite);
            listeStock.add(a);
        }
        catch (CompteException e){
            throw e;
        }
    }

    public void vendre(Article article, double quantite, CompteBanq cb_client, String code_client) throws MagasinException, CompteException {
        if (listeStock.contains(article)){
            double prix = article.getPrixRemise()*quantite;
            int intQuantite = (int) quantite;
            double doubleQuantite = (double)intQuantite;
            if(article.venteALaPiece && doubleQuantite != quantite){
                throw new VenteALaPieceException();
                }
            else if(article.quantite - quantite < 0){
                throw new pasDeStockException();
            }
            else{
                article.quantite -= quantite;
            }
            try{
                cb_client.retrait(prix, code_client);
                CB.versement(prix,code1);
                System.out.println("Paiement effectué, veuillez retirer votre carte bancaire");
            }
            catch(CompteException e){
                article.quantite += quantite;
                throw e;
            }
        }
        else{
            throw new pasDeStockException();
        }
    }

    public void rembourser(Article article, double quantite, CompteBanq cb_client, String code_client) throws MagasinException, CompteException {
        double prix = article.getPrixRemise()*quantite;
        int intQuantite = (int) quantite;
        double doubleQuantite = (double)intQuantite;
        if(article.venteALaPiece && intQuantite != doubleQuantite){
            throw new VenteALaPieceException();
        }
        else{
            article.quantite += quantite;
        }
        try{
            CB.retrait(prix,code1);
            cb_client.versement(prix, code_client);
            System.out.println("Remboursement effectué");
        }
        catch(CompteException e){
            article.quantite -= quantite;
            throw e;
        }
    }

}
