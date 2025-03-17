package TP03_Correction.Ex2_CoursesSki.Donnees;


/**
 * Classe qui simule une base de données : NE PAS MODIFIER
 * Il n'est pas nécessaire que vous cherchiez à comprendre le fonctionnement
 * total de cette classe, l'idée est juste de l'utiliser ailleurs pour récupérer
 * des données.
 */
public class Bdd {

    private static int nbResultats = (int)(10L + Math.round(15.0 * Math.random()));

    private Bdd() {
    }

    /**
     * Renvoi un tableau de dossards générés aléatoirement
     * @return
     */
    public static int[] recupererLesDossards() {
        int[] dossards = new int[nbResultats];

        for(int i = 0; i < dossards.length; ++i) {
            dossards[i] = (int)(100L + Math.round(20.0 * Math.random()));
        }

        return dossards;
    }

    /**
     * Renvoi un tableau de temps générés aléatoirement
     * @return
     */
    public static double[] recupererLesTemps() {
        double[] temps = new double[nbResultats];

        for(int i = 0; i < temps.length; ++i) {
            temps[i] = (double)Math.round(400.0 + 300.0 * Math.random()) / 10.0;
        }

        return temps;
    }
}
