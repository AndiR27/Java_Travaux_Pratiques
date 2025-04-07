package TP05_Correction;

import java.io.File;
import java.util.ArrayList;
import java.util.*;

public class GestionBoisson {

    //On préfère utiliser une map pour gérer le stock entre l'objet Boisson et son nombre
    private static Map<Boisson, Integer> stockBoissons = new HashMap<>();

    public static void main(String[] args) {

        //Attention : le path du fichier peut changer si vous récupérez le code dans votre projet
        chargerData("src/TP05_Correction/stock.csv");
        System.out.println("------ Affichage du Stock ------- \n");
        afficherStock();
        System.out.println();
        System.out.println("------ Ventes de produits ------- \n");
        Boisson b = new Chocolat("Chocolat", 1.5, 25, "au lait");
        servirProduit(b);
        servirProduit(b);
        servirProduit(b);
        System.out.println();
        System.out.println("------ Affichage du Stock ------- \n");
        afficherStock();

    }


    /**
     * Charge le fichier CSV contenant les produits et crée les objets pour les stocker dans une liste
     *
     * @param dataPath
     */
    public static void chargerData(String dataPath) {

        //Le fichier CSV est séparé par des virgules et contient les informations suivantes :
        //2;Chocolat;1.5;25;au lait;;
        String[] data = FileToStr.lireCsv(dataPath);

        for (String ligne : data) {
            //Détérminer le type de boisson
            String[] ligneData = ligne.split(";");
            Boisson b = null;

            if (ligneData[1].equals("Chocolat")) {
                b = new Chocolat(ligneData[1], Double.parseDouble(ligneData[2]), Integer.parseInt(ligneData[3]), ligneData[4]);
            } else if (ligneData[1].equals("Macchiato")) {
                b = new Macchiato(ligneData[1], Double.parseDouble(ligneData[2]), Integer.parseInt(ligneData[3]), ligneData[4], Integer.parseInt(ligneData[5]), Integer.parseInt(ligneData[6]));
            } else if (ligneData[1].equals("Espresso")) {
                b = new Espresso(ligneData[1], Double.parseDouble(ligneData[2]), Integer.parseInt(ligneData[3]), ligneData[4], Integer.parseInt(ligneData[5]), Integer.parseInt(ligneData[6]));

            }

            //On ajoute le produit au stock avec la quantité
            if (b != null) {
                int quantite = Integer.parseInt(ligneData[0]);
                stockBoissons.put(b, quantite);
            }
        }
    }

    /**
     * Affiche le stock de boissons
     */
    public static void afficherStock() {
        for (Map.Entry<Boisson, Integer> entry : stockBoissons.entrySet()) {
            Boisson boisson = entry.getKey();
            int quantite = entry.getValue();
            //On affiche le produit et sa quantité (gestion de l'affichage en fonction de la quantité)
            String affichage = boisson + " : " + quantite + " unités.";
            if (quantite == 0) {
                affichage += " /!\\ A réapprovisionner ! ";
            }
            System.out.println(affichage);
            //On affiche les allergies
            boisson.allergie();
            System.out.println();

        }

        /**
         * Variante d'une boucle for simple sur les clés :
         * for (Boisson b : stockBoissons.keySet()) {
         *   System.out.println(b + " - Quantité : " + stockBoissons.get(b));
         * }
         */
    }

    /**
     * Méthode qui permet de servir un produit
     *
     * @param b : Boisson à servir
     */
    public static void servirProduit(Boisson b) {
        //On vérifie si le produit est en stock
        if (stockBoissons.containsKey(b)) {
            //On vérifie si le stock est suffisant
            if (stockBoissons.get(b) > 0) {
                //On sert le produit
                System.out.println(b + " servi. Santé !");

                //On diminue le stock
                int quantite = stockBoissons.get(b);
                stockBoissons.put(b, quantite - 1);
            } else {
                System.out.println("Impossible de servir " + b + " : stock épuisé.");
            }
        } else {
            System.out.println("Produit non trouvé dans le stock.");
        }
    }

}
