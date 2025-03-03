package TP01_Correction._IntroJava;

/**
Exercice: Gestion des Notes d'Étudiants
Objectif: Créer une fonction qui prend en entrée un tableau de notes d'étudiants (valeurs entières entre 0 et 20),
 calcule et affiche la moyenne, le nombre de notes supérieures à la moyenne, et classe les étudiants en
 deux catégories basées sur cette moyenne: ceux qui ont besoin de soutien et ceux qui sont au-dessus de la moyenne.

Énoncé:
- Déclarer et initialiser un tableau d'entiers avec des valeurs représentant des notes d'étudiants.
- Calculer la moyenne des notes.
- Convertir la moyenne en un entier pour simplifier la comparaison (facultatif).
- Parcourir le tableau pour compter combien d'étudiants ont une note supérieure à la moyenne.
- Afficher la moyenne, le nombre d'étudiants ayant des notes supérieures à la moyenne.
- Utiliser des conditions pour classer les étudiants et afficher un message pour chaque catégorie.
*/
public class ExerciceAvance {

    public static void gererNotesEtudiants() {
        // Votre code ici
        // Déclaration et initialisation du tableau de notes
        int[] notes = {12, 15, 8, 19, 10, 14, 17, 9, 16, 20};

        // Calcul de la somme des notes
        int somme = 0;
        for (int note : notes) {
            somme += note;
        }

        // Calcul de la moyenne
        double moyenne = (double) somme / notes.length;
        int moyenneEntiere = (int) moyenne; // Conversion en entier (facultatif)

        // Comptage des étudiants ayant une note supérieure à la moyenne
        int nbSuperieurMoyenne = 0;
        for (int note : notes) {
            if (note > moyenneEntiere) {
                nbSuperieurMoyenne++;
            }
        }

        // Affichage des résultats
        System.out.println("Moyenne des notes: " + moyenne);
        System.out.println("Nombre d'étudiants au-dessus de la moyenne: " + nbSuperieurMoyenne);

        // Classification des étudiants
        System.out.println("Catégorisation des étudiants:");
        for (int note : notes) {
            if (note >= moyenneEntiere) {
                System.out.println("Note " + note + " : Au-dessus de la moyenne");
            } else {
                System.out.println("Note " + note + " : Besoin de soutien");
            }
        }
    }


    //Pour tester votre fonction, vous pouvez utiliser le code suivant dans la méthode main:
    public static void main(String[] args) {
        gererNotesEtudiants();
    }
}
