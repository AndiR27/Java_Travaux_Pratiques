package TP09_Correction;

import TP09_Correction.Domaine.*;

import java.util.ArrayList;
import java.util.List;

public class GestionPersonnages {
    private static List<PersonnageJouable> personnagesList = new ArrayList<>();

    public static void main(String[] args) {
        //charger les personnages
        System.out.println("\n\n------Chargement des personnages------");
        chargerPersonnages(FileToStr.lireCsv("src/TP09_Correction/personnages.csv"));


        //afficher les personnages
        System.out.println("\n\n------Affichage des personnages------");
        afficherPersonnages();

        //Creer un combat aléatoire
        //afficher les personnages
        System.out.println("\n\n------Lancement d'un combat aléatoire------");
        creerCombatAleatoire();

    }

    /**
     * Créer un combat aléatoire entre deux personnages
     */
    private static void creerCombatAleatoire() {
        int indexPersonnage1 = (int) (Math.random() * personnagesList.size());
        int indexPersonnage2 = (int) (Math.random() * personnagesList.size());
        while (indexPersonnage1 == indexPersonnage2) {
            indexPersonnage2 = (int) (Math.random() * personnagesList.size());
        }
        CombatPersonnage combatPersonnage = new CombatPersonnage(personnagesList.get(indexPersonnage1), personnagesList.get(indexPersonnage2));
        System.out.println(combatPersonnage);
        try {
            combatPersonnage.combat();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    /**
     * Afficher les personnages de la liste
     */
    private static void afficherPersonnages() {
        for (PersonnageJouable personnage : personnagesList) {
            System.out.println(personnage);
        }
    }

    /**
     * Charger les personnages à partir d'un tableau de string
     * @param personnages tableau de string contenant les personnages
     */
    public static void chargerPersonnages(String[] personnages) {
        //charger les personnages
        for (String personnage : personnages) {
            String[] attributs = personnage.split(";");
            PersonnageJouable personnageJouable = null;
            if (attributs[0].equals("G")) {
                 personnageJouable = new Guerrier(attributs[1], Integer.parseInt(attributs[2]), Integer.parseInt(attributs[3]), Integer.parseInt(attributs[4]), Integer.parseInt(attributs[5]), Integer.parseInt(attributs[6]), Integer.parseInt(attributs[7]));
                personnagesList.add(personnageJouable);

            } else if (attributs[0].equals("M")) {
                 personnageJouable = new Mage(attributs[1], Integer.parseInt(attributs[2]), Integer.parseInt(attributs[3]), Integer.parseInt(attributs[4]), Integer.parseInt(attributs[5]), Integer.parseInt(attributs[6]), Integer.parseInt(attributs[7]));
                personnagesList.add(personnageJouable);

            }
            else if (attributs[0].equals("S")){
                 personnageJouable = new Soigneur(attributs[1], Integer.parseInt(attributs[2]), Integer.parseInt(attributs[3]), Integer.parseInt(attributs[4]), Integer.parseInt(attributs[5]), Integer.parseInt(attributs[6]), Integer.parseInt(attributs[7]));
                personnagesList.add(personnageJouable);

            }
            else{
                System.out.println("Le personnage " + attributs[1] + " n'est pas reconnu");
                /**
                 * On aurait pu lever une exception, mais le reste du fichier ne serait pas traité
                 * A la place, il aurait fallu faire un try/catch dans la boucle for ici
                 * qui appelerait la méthode de création de personnage, le throw serait alors
                 * dans la méthode de création de personnage quand on ne reconnait pas le personnage
                 */
            }

        }

    }
}
