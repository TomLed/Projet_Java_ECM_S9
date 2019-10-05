package com.company;
import com.company.enfant.Collegien;
import com.company.enfant.Enfant;
import com.company.enfant.Lyceen;
import com.company.magasin.Magasin;
import com.company.magasin.MagasinExceptions.MagasinException;
import com.company.personne.CBException.CodeCompteException;
import com.company.personne.CBException.CompteException;
import com.company.personne.CompteBanq;
import com.company.personne.Personne;
import com.company.personne.PersonneException.NumSecuException;
import com.company.personne.eleve.EleveDigital;
import com.company.personne.eleve.Note;
import com.company.personne.personnel.Enseignant;
import com.company.personne.personnel.IATOS;
import com.company.magasin.*;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        //test classes enfant
        Lyceen lePetitNicolas = new Lyceen("Petit", "Nicolas", 1996, 'm', 78, "31 rue du Chemin Vert", "2nde");
        System.out.println("Le Petit Nicolas est en: " + lePetitNicolas.getNiveauLyceen());
        System.out.println("A la question passe-t-il un examen, la réponse est " + lePetitNicolas.isPasseUnExamen());
        Collegien lePetitJean = new Collegien("Petit", "Jean", 1996, 'm', 78, "31 rue du Chemin Vert", "3ème");
        System.out.println("Le Petit Jean est en: " + lePetitJean.getNiveauCollegien());
        System.out.println("A la question passe-t-il un examen, la réponse est " + lePetitJean.isPasseUnExamen());

        //test classes élèves

        try{
            EleveDigital antoine = new EleveDigital("Dupont", "Antoine", "153426", "26 rue du truc", 1786537, 2019, 2020);
        }
        catch (NumSecuException e){
            System.out.println("Problème concernant le numéro de Sécurité Sociale de l'élève de Digital Antoine " + e.getMessage());
        }
        try {
            EleveDigital thomas = new EleveDigital("Ledar", "Thomas", "1674352648291", "26 rue du machin", 1786537, 2019, 2200);
            Note premiereNote = new Note("JAVA", 20, 30, true);
            Note deuxiemeNote = new Note("Réseau", 15, 30, true);
            thomas.ajoutNote(premiereNote);
            thomas.ajoutNote(deuxiemeNote);
            thomas.afficherNote();
        }
        catch (NumSecuException e){
            System.out.println("Problème concernant le numéro de Sécurité Sociale de l'élève de Digital Thomas " + e.getMessage());
        }

        try {
            Personne etienne = new Personne("", "Thomas", "1324167543232", "1342");
        } catch (NumSecuException e) {
            System.out.println(e.getMessage());
        }

        //test Classes Personnel
        Habit jean = new Habit("Jean Levi's", 70);
        Habit veste = new Habit("Veste Levi's", 124);
        Habit luxe = new Habit("sac Gucci", 1300);
        Habit calecon = new Habit ("DIM", 10);
        try {
            Enseignant Mariam = new Enseignant("Kiki", "Mariam", "2374864538193", "45, rue du bidulchouette", "2024", "PROF", true);
            Mariam.setTempsTravail(132);
            System.out.println("Le salaire de Mariam est de " + Mariam.calculSalaire() + " €");
            CompteBanq compteBanqMariam = new CompteBanq("1234", "4321");
            compteBanqMariam.setClient(Mariam);
            try {
                compteBanqMariam.versement(Mariam.calculSalaire(), "1234");

                Magasin leviStore = new Magasin("Levi's Store", "31 rue de la soif", 23, "5678", "8765");
                leviStore.ajouterDuCapital(5000);
                leviStore.acheterArticle(jean, 2);
                System.out.println("Le magasin a " + jean.getQuantite() + " jeans en stock");
                leviStore.acheterArticle(veste, 3);
                leviStore.acheterArticle(luxe, 1);
                leviStore.acheterArticle(calecon,23);
                System.out.println(leviStore.CB.getSolde());
                leviStore.vendre(jean, 1, compteBanqMariam, "1234");
                try{
                    leviStore.vendre(luxe, 1, compteBanqMariam, "1234");
                } catch (CompteException e){
                    System.out.println(e.getMessage());
                }
                try{
                    leviStore.vendre(veste, 4, compteBanqMariam, "1234");
                }catch (MagasinException e){
                    System.out.println(e.getMessage());
                }
                try{
                    leviStore.vendre(calecon, 2.7, compteBanqMariam, "1234");
                }catch (Exception e){
                    System.out.println(e.getMessage());
                }
            }
            catch (Exception e) {
                    System.out.println(e.getMessage());
                }
        }
        catch(NumSecuException e){
            System.out.println(e.getMessage());
        }
        System.out.println("Mariam vient d'acheter un jean. Elle n'a pas pu acheter le vêtement de luxe car elle n'a pas assez d'argent.\nElle n'a pas pu acheter les 4 vestes car il n'y en a pas assez en stock.\nElle n'a pas pu acheter de caleçon car ils se vendent à la pièce et elle en demandait 2,7. \nLe magasin a encore " + jean.getQuantite() +" jeans en stock");

    }
}



/*
Vous serez évalués sur le projet suivant :

Tout d’abord il reprend le dernier exo de chaque TP (Personne…)
Ensuite il faut faire une classe article ayant comme sous-classes  Primeur, Habit, Electromenager ;

puis les interfaces IPubicite, IVendrePiece, IVendreKilo , ISolde et  aussi la classe pasEntre0et100Exception

Ipublicite suivant les produits on affiche un slogan
pasEntre0et100Exception attention au taux des soldes

IVendrePiece contient les signatures des méthodes pour vendre et rembourser des articles vendus à la pièce

IVendreKilo contient les signatures des méthodes pour vendre et rembourser des articles vendus au kilo

ISolde contient les méthodes qui permettent de connaître le taux, de lancer les soldes sur un article , d’arrêter les soldes

 Ajoutez :La classe magasin :
Un magasin a un nom , une adresse, un nombre de vendeurs, une variable lui permet de savoir les articles qu’il a en stock et une autre (ou tout dans la même à vous de gérer) la quantité de chaque article en stock. Et bien sûr la caisse du magasin.
Dans la fonction main : créez un magasin, en lui donnant de l’argent pour sa caisse .  Faites lui acheter des articles, mettez des articles en soldes, gérez les slogans publicitaires à plusieurs niveaux d’héritage.
Lien avec le début du projet : Une personne ayant un compte bancaire, créez un prof et faites lui acheter des habits.
Débrouillez-vous pour qu’un enfant de moins de 10 ans ne puisse pas faire des achats dans le magasin.

Si tout cela est réalisé correctement : vous pourrez ajouter une classe alcool sous classe de la classe article que vous définirez comme vous voulez mais seules les personnes majeures pourront acheter de l’alcool.

Il sera ajouté une partie fichier suite au dernier cours.

Il vous est demandé de rendre :
    • Le projet créé sous IntellijIDEA contenant bien sûr les sources.java.
    • Un petit écrit contenant les boîtes UML de chaque  classe (nom, variables d’instance et variables de classe , méthodes d’instance et méthodes de classes avec leur accessibilité) et aussi les liens qui les lient : héritage, composition, implémentation. Dans cet écrit vous pourrez mettre toute explication que vous jugez nécessaire à la compréhension de votre projet ; il doit , en effet, nous paraître clair et bien structuré.
Avancez pas à pas il est préférable de bien faire ce qui est fait quitte à ne pas s’attaquer à la fin.
 */