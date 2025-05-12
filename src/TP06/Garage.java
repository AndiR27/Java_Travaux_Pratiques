package TP06;

import java.util.ArrayList;
import java.util.HashMap;

public class Garage {

    // les variables de Garage permettant de gérer les vehicules à l'intérieur de celui-ci
    private ArrayList<Vehicule> vehiculesList = new ArrayList<>();
    private HashMap<Integer, ArrayList<Vehicule>> vehiculesDico = new HashMap<>();

    public void main(){
        Moto m1 = new Moto("kawasaki", "z900", 2017, "BE0202022", 2019, 948);
        Moto m2 = new Moto("Suzuki", "SV650", 2014, "VS0203045", 2017, 650);
        Voiture v1 = new Voiture("Renault", "Clio", 2010, "GE1234567", 2012, 98);
        Voiture v2 = new Voiture("Porsche", "911", 2016, "GE0987654", 2017, 368);
        entreeVehicule(m1);
        entreeVehicule(m2);
        entreeVehicule(v1);
        entreeVehicule(v2);
        System.out.println();
        System.out.println("Affichage liste des vehicules : ");
        afficherVehicules();
        System.out.println("Test présent");
        vehiculePresent("BE0202022");
        System.out.println();

        System.out.println("Chargement de la map");
        chargerMap();
        System.out.println("Affichage carnet : ");
        afficherCarnetVehicule();
        System.out.println();

        System.out.println("Email : ");
        envoiPromotion();
        System.out.println();

        System.out.println("Revision de tous les vehicules puis affichage !");
        reviserToutesLesVehicules();
        afficherVehicules();
        System.out.println();

        System.out.println("Affichage carnet (après révision): ");
        chargerMap();
        afficherCarnetVehicule();
        System.out.println();

        System.out.println("Email : ");
        envoiPromotion();
        System.out.println();

        System.out.println("Sortie de la suzuki, puis affichage");
        sortieVehicule(m2);
        afficherVehicules();
        System.out.println();

        System.out.println("Affichage carnet final: ");
        afficherCarnetVehicule();


    }



    /**
     * Ajout d'un vehicule dans la liste
     * @param v : vehicule
     */
    public void entreeVehicule(Vehicule v) {
        vehiculesList.add(v);
    }

    /**
     * Suppression d'un vehicule dans la liste
     * @param v : vehicule
     */
    public void sortieVehicule(Vehicule v){
        vehiculesList.remove(v);
    }

    /**
     * Définir l'année de révision à 2024 pour tous les véhicule de la liste
     */
    public void reviserToutesLesVehicules(){
        for(Vehicule v : vehiculesList){
            v.setAnneeRevision(2024);
        }
    }

    /**
     * Affiche tous les vehicules dans la liste grace à leur toString()
     */
    public void afficherVehicules(){
        for(Vehicule v : vehiculesList){
            System.out.println(v);
        }
    }

    /**
     * Tester si un vehicule est présent dans la liste grace au equals
     * @param plaque : plaque d'immatriculation d'un vehicule
     */
    public void vehiculePresent(String plaque){
        Vehicule voitureTest = new Vehicule(plaque);
        for(Vehicule v : vehiculesList){
            if(v.equals(voitureTest)){
                System.out.println(v + " est présent");
            }
        }
    }

    /**
     * Charger la map de clé : année et valeur : liste de vehicule
     */
    public void chargerMap(){
        vehiculesDico = new HashMap<>();
        //parcours de la liste de vehicule
        for(Vehicule v : vehiculesList){
            //pouvoir ajouter une clé dans le dico, avec une liste vide mais créée
            if(!vehiculesDico.containsKey(v.getAnneeRevision())){
                vehiculesDico.put(v.getAnneeRevision(), new ArrayList<>());
            }
            vehiculesDico.get(v.getAnneeRevision()).add(v);
        }
    }

    /**
     * sert à afficher le carnet qui est un dictionnaire regroupant les années et vehicules
     */
    public void afficherCarnetVehicule(){
        //Parcours des clé pour les années
        for(Integer annee : vehiculesDico.keySet()){
            System.out.println("------" + annee + "------");
            //Parcours des valeurs selon la clé : liste de vehicules
            for(Vehicule v : vehiculesDico.get(annee)){
                System.out.println(v);
            }
        }
    }

    /**
     * Afficher un mail de promotion aux vehicules avec une année de révision égal ou moins que 2018
     */
    public void envoiPromotion() {
        boolean mail = false;
        for(Integer annee : vehiculesDico.keySet()){
            if(annee <= 2018){
                mail = true;
                for(Vehicule v : vehiculesDico.get(annee)){
                    System.out.println(v);
                }
            }
        }
        if(!mail){
            System.out.println("Aucun mail à envoyer");
        }
    }

}
