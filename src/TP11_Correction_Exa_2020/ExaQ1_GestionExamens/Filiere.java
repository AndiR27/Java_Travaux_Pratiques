package TP11_Correction_Exa_2020.ExaQ1_GestionExamens;

/**
 * Définition d'une Filiere.
 *
 * @author (votre nom)
 */
public class Filiere
{
    private String code;    // identifiant
    private String nom;
    private String responsable;
    
    public Filiere(String code, String nom, String responsable) {
        this.code=code; this.nom=nom; this.responsable=responsable;
    }

    public String getCode() {
        return code;
    }

    @Override
    public String toString() {
        return nom + " (" + code + "), responsable: " + responsable;
    }
}