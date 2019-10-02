package com.company.magasin;

public class Habit extends Article{

    public Habit (String nom, int quantite, double prixInitial){
        // Les vêtements se vendent à la pièce
        super(nom, quantite, " À quoi ça sert d'imaginer des vêtements si on peut rien faire dedans ?", prixInitial, true);
    }
}
