package TP03_Correction.Ex2_CoursesSki.Application;

import TP03_Correction.Ex2_CoursesSki.Domaine.Resultat;
import TP03_Correction.Ex2_CoursesSki.Donnees.Bdd;

import java.awt.image.AreaAveragingScaleFilter;
import java.util.ArrayList;
import java.util.List;

/**
 * Cette classe ne contient pas de methode main, il faudra l'utiliser
 * dans la classe Main pour lancer la méthode principale
 */
public class StatCourse {

    //La liste des résultats
    private static List<Resultat> resultats = new ArrayList<>();

    /**
     * Méthode principale qui lancera les autres afin d'afficher les statistiques de la course
     * Décommentez petit à petit afin de tester votre code
     */
    public static void afficherStats() {

        resultats = chargerResultats();
        afficherResultats(resultats);
        plusRapide(resultats);

        //Example avec le dossard 116
        nbFois(116);

    }

    /**
     * Méthode qui charge les résultats de la course
     *
     * @return la liste des résultats
     */
    public static List<Resultat> chargerResultats() {
        int[] dossards = Bdd.recupererLesDossards();
        double[] temps = Bdd.recupererLesTemps();
        for (int i = 0; i < dossards.length; i++) {
            resultats.add(new Resultat(dossards[i], temps[i]));
        }
        return resultats;
    }

    /**
     * Méthode qui affiche les résultats de la course
     *
     * @param resultats la liste des résultats
     */
    public static void afficherResultats(List<Resultat> resultats) {
        System.out.println("Résultats de la course : ");
        for (Resultat resultat : resultats) {
            System.out.println(resultat);
        }
    }

    /**
     * Méthode qui affiche le dossard du skieur le plus rapide
     *
     * @param resultats la liste des résultats
     */
    public static void plusRapide(List<Resultat> resultats) {
        //Plusieurs façon de faire : le plus simple c'est stocker le resultat à la première position de la liste
        //comme étant le plus rapide et comparer avec les autres
        Resultat plusRapide = resultats.get(0);
        for (Resultat resultat : resultats) {
            if (resultat.comparerTemps(plusRapide)) {
                plusRapide = resultat;
            }
        }
        System.out.println("Plus rapide " + plusRapide);

    }

    /**
     * Méthode qui affiche le nombre de fois qu'un skieur a participé à la course
     *
     * @param dossard le dossard du skieur
     */
    public static void nbFois(int dossard) {
        //Le plus simple est de faire un compteur et parcourir la liste
        //On essaie tout de même de comparer les Resultat avec un equals selon le dossard
        int nbFois = 0;

        //Création de l'objet resultat contenant le dossard à tester (son temps est pas important)
        Resultat resultatTest = new Resultat(dossard, 0);
        for (Resultat resultat : resultats) {
            if (resultat.equals(resultatTest)) {
                nbFois++;
            }
        }
        System.out.println("Le skieur au dossard '" + dossard + "' a effectué " + nbFois + " fois la course");
    }


}
