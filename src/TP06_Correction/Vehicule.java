package TP06_Correction;

import java.util.Objects;

public class Vehicule {
    //variables de la classe Vehicule
    private String marque;
    protected String modele;
    private int annee;
    private String plaqueImmatriculation;
    private int anneeRevision;

    public Vehicule(String marque, String modele, int annee, String plaqueImmatriculation, int anneeRevision) {
        this.marque = marque;
        this.modele = modele;
        this.annee = annee;
        this.plaqueImmatriculation = plaqueImmatriculation;
        this.anneeRevision = anneeRevision;
    }

    public Vehicule(String plaqueImmatriculation){
        this.plaqueImmatriculation = plaqueImmatriculation;
    }

    public String getMarque() {
        return marque;
    }

    public void setAnneeRevision(int anneeRevision) {
        this.anneeRevision = anneeRevision;
    }

    @Override
    public String toString() {
        return "marque='" + marque + '\'' +
                ", modele='" + modele + '\'' +
                ", annee=" + annee +
                ", plaqueImmatriculation='" + plaqueImmatriculation + '\'' +
                ", anneeRevision=" + anneeRevision;
    }

    public String getplaqueImmatriculation() {
        return plaqueImmatriculation;
    }

    public int getAnneeRevision() {
        return anneeRevision;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null) return false;
        Vehicule vehicule = (Vehicule) o;
        return Objects.equals(plaqueImmatriculation, vehicule.plaqueImmatriculation);
    }

}
