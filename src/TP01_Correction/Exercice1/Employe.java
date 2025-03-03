package TP01_Correction.Exercice1;

/**
 * Classe représentant un employé avec ses informations personnelles et professionnelles.
 * Permet de calculer le bonus de salaire et d'afficher les informations de l'employé.
 */
public class Employe {
    // Variables d'instance représentant les attributs de l'employé
    private String nom;
    private String prenom;
    private String adresse;
    private String fonction;
    private int anneeDansLEntreprise;
    private int salaireMensuel;

    /**
     * Constructeur de la classe Employe.
     *
     * @param nom Nom de l'employé
     * @param prenom Prénom de l'employé
     * @param adresse Adresse de l'employé
     * @param fonction Fonction occupée par l'employé
     * @param anneeDansLEntreprise Nombre d'années passées dans l'entreprise
     * @param salaireMensuel Salaire mensuel de l'employé en CHF
     */
    public Employe(String nom, String prenom, String adresse, String fonction, int anneeDansLEntreprise, int salaireMensuel) {
        this.nom = nom;
        this.prenom = prenom;
        this.adresse = adresse;
        this.fonction = fonction;
        this.anneeDansLEntreprise = anneeDansLEntreprise;
        this.salaireMensuel = salaireMensuel;
    }

    /**
     * Met à jour l'adresse de l'employé.
     *
     * @param adresse Nouvelle adresse de l'employé
     */
    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    /**
     * Met à jour le nombre d'années passées dans l'entreprise.
     *
     * @param annee Nouvelle valeur du nombre d'années dans l'entreprise
     */
    public void setAnneeDansLEntreprise(int annee) {
        this.anneeDansLEntreprise = annee;
    }

    /**
     * Calcule le salaire avec le bonus basé sur l'ancienneté.
     * Le bonus est de 1% du salaire mensuel par année d'ancienneté.
     *
     * @return Le salaire mensuel incluant le bonus
     */
    public float calculBonus() {
        return salaireMensuel + (salaireMensuel / 100.0f) * anneeDansLEntreprise;
    }

    /**
     * Affiche les informations de l'employé.
     */
    public void afficher() {
        System.out.println(nom + " " + prenom + ", " + adresse + ". Fonction : " + fonction + "\n" +
                anneeDansLEntreprise + " années dans l'entreprise. Salaire : " + calculBonus() +
                " CHF par mois, " + salaireMensuel + " CHF sans bonus");
    }
}
