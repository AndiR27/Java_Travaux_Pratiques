package TP11_Correction_Exa_2020.ExaQ1_GestionExamens;

import java.util.ArrayList;
import java.util.List;

/**
 * Définition d'un Etudiant.
 *
 * @author (votre nom)
 */
public class Etudiant
{
    private int no;         // identifiant
    private String nom;
    private String prenom;
    private Filiere filiere;
    private List<Examen> examens;

    public Etudiant(int no, String nom, String prenom, Filiere filiere) {
        this.no = no;
        this.nom = nom;
        this.prenom = prenom;
        this.filiere = filiere;
        this.examens = new ArrayList<>();
    }

    public int getNo() {
        return no;
    }

    public String getNom() {
        return nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void addExamen(Examen exa){
        this.examens.add(exa);
    }

    @Override
    public String toString() {
        //Gaston Lagaffe (IG)
        return nom + " " + prenom + "(" + filiere.getCode() + ")";
    }

    public void afficherExamens() {
        System.out.println("\n" + this);
        for(Examen exa : examens){
            System.out.println("- " + exa);
        }
    }
}