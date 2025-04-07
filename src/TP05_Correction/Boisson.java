package TP05_Correction;

import java.util.Objects;

public abstract class Boisson {
    private String nom;
    private Double prix;
    private int taille;

    public Boisson(String nom, Double prix, int taille) {
        this.nom = nom;
        this.prix = prix;
        this.taille = taille;
    }

    public abstract void allergie();

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Boisson boisson = (Boisson) o;
        return Objects.equals(nom, boisson.nom) && Objects.equals(prix, boisson.prix);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nom, prix);
    }

    @Override
    public String toString() {
        return this.nom + "(" + this.prix + "Chf) - " + this.taille + "cl";
    }
}
