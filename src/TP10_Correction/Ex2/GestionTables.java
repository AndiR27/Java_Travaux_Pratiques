package TP10_Correction.Ex2;

import TP10_Correction.Ex2.Domaine.*;

import java.util.Comparator;
import java.util.List;

public class GestionTables {
    private static List<Table> listeTables = Bdd.getListeTables();

    public GestionTables() {
        afficherTablesEn(Matiere.BOIS);
        System.out.println();
        afficherTablesParSurface();
    }

    private void afficherTablesEn(Matiere matiere) {
        System.out.println("Liste des tables en " + matiere + " (triées par code) :");
        listeTables.sort(null);
        for (Table table : listeTables) {
            if (table.estEn(matiere)) {
                System.out.println(table);
            }
        }
    }

    private void afficherTablesParSurface() {
        System.out.println("Liste des tables triées par surface (de la plus grande à la plus petite) :");
        /**
         * On utilise une classe anonyme pour implémenter l'interface Comparator
         * afin de trier les tables par surface.
         * => Nous n'avons pas vu ça en labo, mais c'est une pratique courante, je vous invite à toujours externaliser
         * le Comparator dans une classe à part pour vous y retrouver plus facilement.
         */
        listeTables.sort(new Comparator<Table>() {
            @Override
            public int compare(Table o1, Table o2) {
                return o2.compareSurface(o1);
            }
        });
        for (Table table : listeTables) {
            System.out.println(table);
        }
    }
}