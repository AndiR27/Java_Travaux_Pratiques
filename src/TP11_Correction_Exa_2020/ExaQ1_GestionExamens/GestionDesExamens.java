package TP11_Correction_Exa_2020.ExaQ1_GestionExamens;

import java.util.ArrayList;

/**
 * Application de GestionDesExamens :
 * - chargement du contenu des 3 fichiers en mémoire, dans 3 ArrayList (filieres, examens et etudiants).
 * - chargement des inscriptions des étudiants aux différents examens.
 * - les fichiers fournis sont VALIDES : aucun test à faire : tous les types sont corrects, toutes les données existent.
 * - la méthode FileToStr.lireCsv() retourne un tableau à 2 dimensions : lignes & colonnes !!
 * <p>
 * Vous devez fournir 2 nouvelles méthodes :
 * - afficherQuiEtaitLa(int jour, int heure, String lieu) : Affiche l'examen qui a eu lieu tel jour, telle heure dans ce lieu, ainsi que la liste des étudiants inscrits.
 * - afficherMesExamens(String nom, String prenom) : Affiche la liste des examens auxquels est inscrit nom-prenom.
 *
 * @author (votre nom)
 */
public class GestionDesExamens {
    // Ces 4 instructions (chargement des données) seront automatiquement exécutées à chaque test :
    private static ArrayList<Filiere> filieres = chargerFilieres();
    private static ArrayList<Examen> examens = chargerExamens();
    private static ArrayList<Etudiant> etudiants = chargerEtudiants();

    static {
        chargerInscriptions();
    }

    /**
     * Charge le fichier "LstFilieres.csv" dans l'ArrayList filieres.
     */
    private static ArrayList<Filiere> chargerFilieres() {
        filieres = new ArrayList<>();
        for (String[] ligne : FileToStr.lireCsv("src/TP11_Correction_Exa_2020/ExaQ1_GestionExamens/LstFilieres.csv")) {
            filieres.add(new Filiere(ligne[0], ligne[1], ligne[2]));
        }
        return filieres;
    }

    /**
     * Charge le fichier "LstExamens.csv" dans l'ArrayList examens.
     * La méthode FileToStr.lireCsv() retourne un tableau à 2 dimensions : lignes & colonnes.
     */
    private static ArrayList<Examen> chargerExamens() {
        examens = new ArrayList<>();
        for (String[] ligne : FileToStr.lireCsv("src/TP11_Correction_Exa_2020/ExaQ1_GestionExamens/LstExamens.csv")) {
            // ===== À COMPLÉTER =====
            //creer les bons attributs, creer l'objet examen, ajouter dans la liste
            //41;IG;632-2 Réseau;8;8;FR13
            int no = Integer.parseInt(ligne[0]);
            String codeFiliere = ligne[1];
            String module = ligne[2];
            int jour = Integer.parseInt(ligne[3]);
            int heure = Integer.parseInt(ligne[4]);
            String lieu = ligne[5];
            Filiere filiere = trouverFiliere(codeFiliere);
            Examen exa = new Examen(no, module, jour, heure, lieu, filiere);
            examens.add(exa);

        }
        return examens;
    }

    private static Filiere trouverFiliere(String codeFiliere) {
        for (Filiere filiere : filieres) {
            if(codeFiliere.equals(filiere.getCode())){
                return filiere;
            }
        }
        return null;
    }

    /**
     * Charge le fichier "LstEtudiants.csv" dans l'ArrayList etudiants.
     * La méthode FileToStr.lireCsv() retourne un tableau à 2 dimensions : lignes & colonnes.
     */
    private static ArrayList<Etudiant> chargerEtudiants() {
        etudiants = new ArrayList<>();
        for (String[] ligne : FileToStr.lireCsv("src/TP11_Correction_Exa_2020/ExaQ1_GestionExamens/LstEtudiants.csv")) {
            // ===== À COMPLÉTER =====
            //401;Gaston;Lagaffe;IG
            int no = Integer.parseInt(ligne[0]);
            String nom = ligne[2];
            String prenom = ligne[1];
            String codeFiliere = ligne[3];
            Filiere filiere = trouverFiliere(codeFiliere);
            Etudiant etu = new Etudiant(no, nom, prenom, filiere);
            etudiants.add(etu);
        }
        return etudiants;
    }

    /**
     * Enregistre quel étudiant est inscrit à quel examen.
     * C'est à vous de choisir où et comment conserver ces informations.
     * Le fichier "LstInscriptions.csv" contient la liste des étudiants, avec la liste des examens auquels ils sont inscrits.
     * La méthode FileToStr.lireCsv() retourne un tableau à 2 dimensions : lignes & colonnes.
     */
    private static void chargerInscriptions() {
        for (String[] ligne : FileToStr.lireCsv("src/TP11_Correction_Exa_2020/ExaQ1_GestionExamens/LstInscriptions.csv")) {
            // ===== À COMPLÉTER =====
            //101;11;12;13;16
            int noEtu = Integer.parseInt(ligne[0]);
            Etudiant etu = trouverEtudiant(noEtu);
            for(int i = 1; i < ligne.length; i++){
                int noExa = Integer.parseInt(ligne[i]);
                Examen exa = trouverExamen(noExa);
                if(exa != null && etu != null){
                    exa.addEtudiant(etu);
                    etu.addExamen(exa);
                }
            }
        }
    }

    private static Examen trouverExamen(int noExa) {
        for(Examen exa : examens){
            if(exa.getNo() == noExa){
                return exa;
            }
        }
        return null;
    }

    private static Etudiant trouverEtudiant(int noEtu) {
        for (Etudiant etu : etudiants) {
            if(noEtu == etu.getNo()){
                return etu;
            }
        }
        return null;
    }

    /**
     * Affiche le contenu des 3 ArrayList globales : filieres, examens et etudiants.
     */
    public static void afficherTout() {
        System.out.println("\nFilieres :  ");
        for (Filiere fil : filieres) {
            System.out.println(fil);
        }
        System.out.println("\nExamens :   ");
        for (Examen exa : examens) {
            System.out.println(exa);
        }
        System.out.println("\nEtudiants : ");
        for (Etudiant etu : etudiants) {
            System.out.println(etu);
        }
    }

    /**
     * Affiche l'examen qui a eu lieu tel jour, telle heure dans ce lieu, ainsi que la liste des étudiants inscrits.
     */
    public static void afficherQuiEtaitLa(int jour, int heure, String lieu) {
        // ===== À COMPLÉTER =====
        boolean trouveExam = false;
        for(Examen exa : examens){
            if(exa.presenceExamen(jour, heure, lieu)){
                trouveExam = true;
                exa.afficherEtudiantsInscrits();
            }
        }
        if(!trouveExam){
            //Aucun examen le 10 à 9h, lieu: B4.11
            System.out.println("\nAucun examen le " + jour + " à " + heure + "h, lieu: " + lieu);
        }
    }

    /**
     * Affiche la liste des examens auxquels est inscrit nom-prenom.
     */
    public static void afficherMesExamens(String nom, String prenom) {
        // ===== À COMPLÉTER =====
        boolean trouveEtudiant = false;
        for(Etudiant etu : etudiants){
            if(etu.getPrenom().equals(prenom) && etu.getNom().equals(nom)){
                trouveEtudiant = true;
                etu.afficherExamens();
            }
        }
        if(!trouveEtudiant){
            //Aucun étudiant trouvé avec le nom et prénom donnés
            System.out.println("\nEtudiant " + nom + " " + prenom + " inconnu !");
        }
    }
}