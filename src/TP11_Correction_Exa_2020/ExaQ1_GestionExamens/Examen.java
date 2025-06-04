package TP11_Correction_Exa_2020.ExaQ1_GestionExamens;

import java.util.ArrayList;
import java.util.List;

/**
 * Définition d'un Examen.
 *
 * @author (votre nom)
 */
public class Examen
{
    private int no;         // identifiant
    private String module;
    private int jour;
    private int heure;
    private String lieu;
    private Filiere filiere;
    private List<Etudiant> etudiants;

    public Examen(int no, String module, int jour, int heure, String lieu, Filiere filiere) {
        this.no = no;
        this.module = module;
        this.jour = jour;
        this.heure = heure;
        this.lieu = lieu;
        this.filiere = filiere;
        this.etudiants = new ArrayList<>();
    }

    public int getNo() {
        return no;
    }

    public void addEtudiant(Etudiant etu){
        this.etudiants.add(etu);
    }

    @Override
    public String toString() {
        //Examen IG le 8 à 8h : 632-2 Réseau, lieu: FR1
        return "Examen " + filiere.getCode() + " le " + jour + " à " + heure + "h : " + module + ", lieu : " + lieu;
    }


    public boolean presenceExamen(int jour, int heure, String lieu) {
        return jour == this.jour && heure == this.heure && lieu.equals(this.lieu);
    }

    public void afficherEtudiantsInscrits() {
        System.out.println("\n" + this);
        for(Etudiant etu : etudiants){
            System.out.println("- " + etu);
        }
    }
}