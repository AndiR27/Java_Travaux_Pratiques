package TP05_Correction;

public class Macchiato extends Cafe{

    private int quantiteLait;

    public Macchiato(String nom, Double prix, int taille, String provenance, int force, int quantiteLait) {
        super(nom, prix, taille, provenance, force);
        this.quantiteLait = quantiteLait;
    }

    public void allergie() {
        if (quantiteLait > 0) {
            System.out.println("\t- Contient du lactose");

        }

    }

    @Override
    public String toString() {
        return super.toString() + " " + this.quantiteLait + "cl de lait";
    }
}
