package TP01_Correction._IntroJava;

import java.util.ArrayList;

public class ExerciceIntroduction {

    /**
     * Exercice 1: variables et conversions
     */
    public static void testerVariablesEtConversions() {
        // Déclaration des variables
        int entier = 10;
        double reel = 5.75;
        String texte = "Java";

        // Affichage des valeurs
        System.out.println("Entier: " + entier);
        System.out.println("Réel: " + reel);
        System.out.println("Texte: " + texte);

        // Conversion d'un entier en double
        double conversionDouble = (double) entier;
        System.out.println("Conversion de l'entier en double: " + conversionDouble);

        // Conversion d'un double en entier
        int conversionEntier = (int) reel;
        System.out.println("Conversion du double en entier: " + conversionEntier);

        // Addition des trois variables (avec conversion nécessaire)
        String resultat = entier + reel + texte;
        System.out.println("Addition des variables: " + resultat);
    }

    /**
     * Exercice 2: Conditions
     */
    public static String testerLesConditions(int nombre) {
        if (nombre > 0) {
            return "positif";
        } else if (nombre < 0) {
            return "négatif";
        } else {
            return "zéro";
        }
    }

    /**
     * Exercice 3: Boucles
     */
    public static void testerLesBoucles() {
        // Boucle for de 1 à 5
        for (int i = 1; i <= 5; i++) {
            System.out.println("For: " + i);
        }

        // Boucle while de 5 à 1
        int j = 5;
        while (j >= 1) {
            System.out.println("While: " + j);
            j--;
        }
    }

    /**
     * Exercice 4: Manipuler les tableaux
     */
    public static void testerLesTableaux() {
        // Déclaration et initialisation d'un tableau d'entiers
        int[] tableau = {2, 4, 6, 8, 10};

        // Affichage des éléments du tableau
        System.out.print("Éléments du tableau: ");
        for (int valeur : tableau) {
            System.out.print(valeur + " ");
        }
        System.out.println();

        // Calcul et affichage de la somme des éléments
        int somme = 0;
        for (int valeur : tableau) {
            somme += valeur;
        }
        System.out.println("Somme des éléments: " + somme);
    }

    /**
     * Exercice 5 : Manipuler les listes
     * - Créer une liste d'entiers et ajouter des valeurs.
     * - Utiliser une boucle pour afficher tous les éléments de la liste.
     * - Calculer et afficher la somme des éléments de la liste.
     *
     * Pour creer une arrayList, il faut importer la classe java.util.ArrayList, et utiliser la syntaxe suivante:
     * ArrayList<Integer> liste = new ArrayList<>();
     */
    public static void testerLesListes(){
        // Votre code ici
        ArrayList<Integer> liste = new ArrayList<>();
        liste.add(1);
        liste.add(3);
        liste.add(5);
        liste.add(7);

        int somme = 0;
        for(int i : liste){
            somme += i;
        }
        System.out.println("Somme des éléments : " + somme);
    }


}
