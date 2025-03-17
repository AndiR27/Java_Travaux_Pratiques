package TP03_Correction.Ex1_Restaurant;

public class Plat {
    private String nom;
    private String type;

    public Plat(String nom, String type) {
        this.nom = nom;
        this.type = type;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    @Override
    public String toString() {
        return nom + " (" + type + ")";
    }

    @Override
    public boolean equals(Object obj) {
        Plat p = (Plat) obj;
        return nom.equals(p.getNom());
    }

}
