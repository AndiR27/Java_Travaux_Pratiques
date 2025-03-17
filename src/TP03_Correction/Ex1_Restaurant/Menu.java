package TP03_Correction.Ex1_Restaurant;

import java.util.*;

public class Menu {
    private String nom;

    private int prix;

    private List<Plat> plats;

    public Menu(String nom, int prix) {
        this.nom = nom;
        this.prix = prix;
        this.plats = new ArrayList<>();
    }


    public void AjoutPlat(Plat plat) {
        if (this.plats.size() < 5) {
            plats.add(plat);
        }
        else{
            System.out.println("Erreur : Il ne peut pas y avoir plus que 5 plats dans un menu." );
        }
    }

    public boolean trouverPlat(Plat p){
        return plats.contains(p);
    }

    /**
     * Permet d'afficher les plats du menu dans le toString de Menu
     * @return
     */
    public String afficherPlats() {
        String res = "";
        for (Plat plat : plats) {
            res += plat + " ";
        }
        return res;
    }

    @Override
    public String toString() {
        return "le Menu " + nom + " à " + prix + "Chf composé de :\n" + afficherPlats();
    }
}
