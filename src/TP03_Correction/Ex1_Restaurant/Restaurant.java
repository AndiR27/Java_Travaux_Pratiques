package TP03_Correction.Ex1_Restaurant;

import java.util.*;

public class Restaurant
{
    /**
     * Cette classe restaurant sert principalement de test pour l'exercice 1
     * et simule le fonctionnement d'une classe "Main" : Pour pouvoir tester votre
     * code, il suffit juste de décommenter.
     */
    private static List<Menu> menuPlat = new ArrayList<>();
    public static void main(String[] args)
    {

        Plat p1 = new Plat("Cassoulet", "Plat");
        Plat p2 = new Plat("Pâtes au saumon", "Plat");
        Plat p3 = new Plat("Salade verte", "Entrée");
        Plat p4 = new Plat("Assiette Valaisanne", "Entrée/Plat");
        Plat p5 = new Plat("Coupe Danemark", "Dessert");
        Plat p6 = new Plat("Quiche Lorraine", "Plat");
        Plat p7 = new Plat("Pizza 4 saisons", "Plat");
        Plat p8 = new Plat("Tartare d'aubergines", "Entrée");
        Plat p9 = new Plat("Salade Niçoise", "Entrée/Plat");
        Plat p10 = new Plat("Profiteroles", "Dessert");
        Menu m1 = new Menu("du jour", 35);
        Menu m2 = new Menu("de saison", 40);
        Menu m3 = new Menu("duo", 60);
        Menu m4 = new Menu("enfant", 25);
        Menu m5 = new Menu("découverte", 45);

        m1.AjoutPlat(p1);
        m1.AjoutPlat(p2);
        m1.AjoutPlat(p5);
        menuPlat.add(m1);
        m2.AjoutPlat(p1);
        m2.AjoutPlat(p10);
        menuPlat.add(m2);
        Recherche(p6);
        Recherche(p1);

    }

    /**
     * Methode permettant de rechercher un plat dans les menus et faire l'affichage du resultat
     * @param p : L'objet Plat à rechercher
     */
    public static void Recherche(Plat p){
        System.out.println("\nRercherche de " + p);
        boolean trouvee = false;
        String affichageTrouve = "";
        for(Menu m : menuPlat){
            if(m.trouverPlat(p)){
                trouvee = true;
                affichageTrouve = "Le plat " + p + " se trouve dans le " + m;
            }
        }

        if(trouvee) {
            System.out.println(affichageTrouve);
        }
        else{
            System.out.println("Le plat " + p + " n'est dans aucune menu");
        }
    }




}