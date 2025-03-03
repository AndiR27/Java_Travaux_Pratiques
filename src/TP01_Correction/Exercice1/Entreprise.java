package TP01_Correction.Exercice1;

/**
 * Classe représentant une entreprise avec ses informations générales.
 * Permet de modifier certains attributs et d'afficher les informations de l'entreprise.
 */
public class Entreprise {
    // Variables d'instance représentant les caractéristiques de l'entreprise
    private String nom;
    private String adresse;
    private String type;
    private int nbBatiment;
    private String domaine;
    private int nbEmploye;
    private String detenteurMajoritaire;

    /**
     * Constructeur de la classe Entreprise.
     *
     * @param nom Nom de l'entreprise
     * @param adresse Adresse de l'entreprise
     * @param type Type d'entreprise (Privée, Publique, etc.)
     * @param nbBatiment Nombre de bâtiments de l'entreprise
     * @param domaine Domaine d'activité de l'entreprise
     * @param nbEmploye Nombre d'employés dans l'entreprise
     * @param detenteurMajoritaire Détenteur majoritaire de l'entreprise
     */
    public Entreprise(String nom, String adresse, String type, int nbBatiment, String domaine, int nbEmploye, String detenteurMajoritaire) {
        // Initialisation des variables d'instance
        this.nom = nom;
        this.adresse = adresse;
        this.type = type;
        this.nbBatiment = nbBatiment;
        this.detenteurMajoritaire = detenteurMajoritaire;
        this.domaine = domaine;
        this.nbEmploye = nbEmploye;
    }

    /**
     * Modifie le nombre de bâtiments de l'entreprise.
     *
     * @param nb Nouveau nombre de bâtiments
     */
    public void changerNbBatiment(int nb) {
        this.nbBatiment = nb;
    }

    /**
     * Met à jour le nombre d'employés de l'entreprise.
     *
     * @param nb Nouveau nombre d'employés
     */
    public void setNbEmploye(int nb) {
        this.nbEmploye = nb;
    }

    /**
     * Affiche les informations de l'entreprise.
     *
     * @param full Si vrai, affiche toutes les informations, sinon affiche uniquement le nom et l'adresse
     */
    public void afficher(boolean full) {
        System.out.println(nom + ", " + adresse);
        if (full) {
            System.out.println("Entreprise " + type + " détenue par " + detenteurMajoritaire + " dans le domaine " + domaine);
            System.out.println("L'entreprise possède " + nbBatiment + " bâtiments pour " + nbEmploye + " employés");
        }
    }

    /**
     * Modifie le type de l'entreprise et ajuste le détenteur majoritaire si elle devient publique.
     *
     * @param type Nouveau type d'entreprise
     */
    public void changerType(String type) {
        this.type = type;
        if (type.equals("Publique")) {
            this.detenteurMajoritaire = "L'Etat";
        }
    }
}
