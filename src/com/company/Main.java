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
        System.out.println(" On réalise des tests de la classe Enfant\n");
        Lyceen lePetitNicolas = new Lyceen("Petit", "Nicolas", 1996, 'm', 78, "31 rue du Chemin Vert", "2nde");
        System.out.println("Le Petit Nicolas est en: " + lePetitNicolas.getNiveauLyceen());
        System.out.println("A la question passe-t-il un examen, la réponse est " + lePetitNicolas.isPasseUnExamen());
        Collegien lePetitJean = new Collegien("Petit", "Jean", 1996, 'm', 78, "31 rue du Chemin Vert", "3ème");
        System.out.println("Le Petit Jean est en: " + lePetitJean.getNiveauCollegien());
        System.out.println("A la question passe-t-il un examen, la réponse est " + lePetitJean.isPasseUnExamen() + "\n\n");

        //test classes élèves
        System.out.println(" On réalise des tests de la classe Elèves\n");
        try{
            System.out.println("On créé un élève avec un némro de sécurité social incomplet");
            EleveDigital antoine = new EleveDigital("Dupont", "Antoine", "153426", "26 rue du truc", 1786537, 2019, 2020);
        }
        catch (NumSecuException e){
            System.out.println("Problème concernant le numéro de Sécurité Sociale de l'élève de Digital Antoine " + e.getMessage() + "\n\n");
        }
        try {
            System.out.println("On créé l'élève Thomas auquel on attribue une note de 20 en JAVA et 15 en réseau");
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


        //test Classes
        System.out.println("\n\n On créé une enseignante et un enfant auxquels on fait acheter des articles dans un magasin");
        Habit jean = new Habit("Jean Levi's", 70);
        jean.ActiverSolde(true, 10);
        Habit veste = new Habit("Veste Levi's", 124);
        Habit luxe = new Habit("sac Gucci", 1300);
        Habit calecon = new Habit ("DIM", 10);
        Alcool ricard = new Alcool("Pastis", 15);
        try {
            Enseignant Mariam = new Enseignant("Kiki", "Mariam", "2024864538193", "45, rue du bidulchouette", "2024", "PROF", true);
            // On créé un enfant de moins de 10 ans
            Personne Nicolas = new Personne("Nicolas", "Jean","1123526144896","565 zegfhzgf");
            Mariam.setTempsTravail(132);
            System.out.println("Le salaire de Mariam est de " + Mariam.calculSalaire() + " €");
            CompteBanq compteBanqMariam = new CompteBanq(Mariam, "1234", "4321");
            CompteBanq compteBanqNicolas = new CompteBanq(Nicolas, "1020","2010");
            try {
                compteBanqMariam.versement(Mariam.calculSalaire(), "1234");
                System.out.println("Le salaire de Mariam est versé sur son compte");
                Magasin leviStore = new Magasin("Levi's Store", "31 rue de la soif", 23, "5678", "8765");
                leviStore.ajouterDuCapital(5000);
                System.out.println("Le magasin a un capital de " + leviStore.getCB().getSolde() + " €");
                leviStore.acheterArticle(jean, 2);
                System.out.println("Le magasin a " + jean.getQuantite() + " jeans en stock");
                leviStore.acheterArticle(veste, 3);
                leviStore.acheterArticle(luxe, 1);
                leviStore.acheterArticle(calecon,23);
                leviStore.acheterArticle(ricard,1);
                System.out.println("Suite aux achats le compte bancaire du magasin a un solde de : " +leviStore.getCB().getSolde()+ " €\n");
                System.out.println("Achat par Mariam d'un jean soldé à " + jean.getPrixRemise() + "Le prix initial était de " + jean.getPrixInitial());
                leviStore.vendre(jean, 1, compteBanqMariam, "1234");
                try{
                    System.out.println("Achat par Mariam d'un vêtement de luxe");
                    leviStore.vendre(luxe, 1, compteBanqMariam, "1234");
                } catch (CompteException e){
                    System.out.println(e.getMessage());
                }
                try{
                    System.out.println("Achat par Mariam de 4 vestes");
                    leviStore.vendre(veste, 4, compteBanqMariam, "1234");
                }catch (MagasinException e){
                    System.out.println(e.getMessage());
                }
                try{
                    System.out.println("Achat par Mariam de 2,7 caleçons");
                    leviStore.vendre(calecon, 2.7, compteBanqMariam, "1234");
                }catch (Exception e){
                    System.out.println(e.getMessage());
                }
                try{
                    System.out.println("Achat par Mariam d'une bouteille de pastis");
                    leviStore.vendre(ricard,1,compteBanqMariam,"1234");
                } catch (Exception e){
                    System.out.println(e.getMessage());
                }
                System.out.println("Mariam vient d'acheter un jean. Elle n'a pas pu acheter le vêtement de luxe car elle n'a pas assez d'argent.\nElle n'a pas pu acheter les 4 vestes car il n'y en a pas assez en stock.\nElle n'a pas pu acheter de caleçon car ils se vendent à la pièce et elle en demandait 2,7. \n Elle n'a pas pu acheter de pastis car elle n'a pas 18 ans. \nLe magasin a encore " + jean.getQuantite() +" jeans en stock");
                System.out.println("Suite aux achat il reste " + compteBanqMariam.getSolde() + " € sur le compte de Mariam\n");
                // Maintenant on essaye de faire acheter à Nicolas qui a moins de 10 ans
                System.out.println("Nicolas essaye d'acheter un calecon");
                leviStore.vendre(calecon, 1,compteBanqNicolas,"1020");
            }
            catch (Exception e) {
                    System.out.println(e.getMessage());
                }
        }
        catch(NumSecuException e){
            System.out.println(e.getMessage());
        }

    }
}



