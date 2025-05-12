package TP08_Correction;

import java.util.ArrayList;

public class GestionAnalyse {

    public static ArrayList<Analyse> analyses = new ArrayList<Analyse>();

    public static void chargerAnalyses(ArrayList<String[]> fichier) throws Exception {
        //Une gestion d’erreur doit être faite si le type n’est pas compris entre « PLA, VHA et TOX ».
        // Un fichier comportant une erreur ne doit pas continuer d’être utilisé après.
        // Pour mettre en place la gestion d’erreur, vous pouvez créer de nouvelles classes et modifier la méthode main fournie.

        //Parcourt normal des données
        for (String[] ligne : fichier) {
            //On crée les objets et on les ajoute à la liste
            if (ligne[1].equals("PLA")) {
                analyses.add(new AnalyseSanguine(Integer.parseInt(ligne[0]), Integer.parseInt(ligne[4]), Integer.parseInt(ligne[3]), ligne[1], Integer.parseInt(ligne[2])));
            } else if (ligne[1].equals("VHA") || ligne[1].equals("TOX")) {
                Boolean analyse = false;
                if (ligne[2].equals("POSITIF")) {
                    analyse = true;
                }
                analyses.add(new AnalyseVirale(Integer.parseInt(ligne[0]), Integer.parseInt(ligne[4]), Integer.parseInt(ligne[3]), ligne[1], analyse));
            }
            //MAIS : dans le cas ou le type n'est pas reconnu, on lève une exception
            else {
                throw new Exception("Erreur de type à la ligne : " + ligne[0] + " : " + ligne[1] + " est inconnu ! La suite du fichier n'a donc pas été prise en ocmpte,");
            }
        }

    }

    public static void afficherAnalyses() {
        //A compléter
        for (Analyse a : analyses) {
            System.out.println(a);
        }
    }

    public static void main(String[] args) {
        System.out.println("----- Chargement du fichier : LstAnalyses.csv -----");
        try {
            chargerAnalyses(FileToStr.lireFichier("src/TP08_Correction/LstAnalyses.csv"));
            System.out.println("\t- Aucune erreur détectée");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        System.out.println("----- Chargement du fichier : LstAnalyses2.csv  -----");
        try {
            chargerAnalyses(FileToStr.lireFichier("src/TP08_Correction/LstAnalyses2.csv"));
            System.out.println("\t- Aucune erreur détectée");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        System.out.println("");
        afficherAnalyses();
    }
}

