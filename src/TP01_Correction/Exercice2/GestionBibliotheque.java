package TP01_Correction.Exercice2;


import java.util.ArrayList;

/**
 * Gestion du logiciel de la bibliothèque
 * Toutes les méthodes dans cette classe sont statiques et ne nécessitent pas d'instance pour être appelées.
 * Methode Main fournie pour tester les différentes fonctionnalités.
 */
public class GestionBibliotheque {

    //Creation des données : une variable static est ainsi accessible par toutes les
    // méthodes de la classe en utilisant la syntaxe suivante :
    // GestionBibliotheque.livres ou tout simplement livres si on est dans la classe
    static ArrayList<Livre> livres = new ArrayList<Livre>();


    public static void main(String[] args) {
        //Creation des données pour remplir la liste de livres
        Livre livre1 = new Livre(1, "L'île mystérieuse", true);
        Livre livre2 = new Livre(2, "Voyage au centre de la Terre", true);
        Livre livre3 = new Livre(3, "De la Terre à la Lune", false);
        livres.add(livre1);livres.add(livre2);livres.add(livre3);

        //Tests des différentes méthodes
        // Il suffit de retirer le bloc de commentaire au début et à la fin pour
        // tester chaque méthode

        System.out.println(ajouterLivre(4, "Histoire d'un casse-noisette"));

        int testIdDispo = 2;
        boolean dispo = livreDisponible(testIdDispo);
        System.out.println("Le livre avec l'id " + testIdDispo + " est disponible: " + dispo);

        int testIdModif = 3;
        System.out.println(modifierDisponibilite(testIdModif, true));

        afficherLivres();


    }

    //Vos méthodes ici (ne pas oublier le static à chaque méthode)

    public static String ajouterLivre(int id, String titre) {
        Livre livre = new Livre(id, titre, true);
        livres.add(livre);
        return "Le livre avec l'id " + id + " a été ajouté avec succès.";
    }

    public static boolean livreDisponible(int id) {
        for (Livre livre : livres) {
            if (livre.getId() == id) {
                return livre.isDisponible();
            }
        }
        return false;
    }

    public static String modifierDisponibilite(int id, boolean dispo) {
        for (Livre livre : livres) {
            if (livre.getId() == id) {
                livre.setDisponible(dispo);
                return "La disponibilité du livre avec l'id " + id + " a été modifiée avec succès.";
            }
        }
        return "Le livre avec l'id " + id + " n'existe pas.";
    }

    public static void afficherLivres() {
        for (Livre livre : livres) {
            System.out.println(livre);
        }
    }

}
