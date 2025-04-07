package TP05_Correction;

public class Espresso extends Cafe{
    private int quantiteCreme;

    public Espresso(String nom, Double prix, int taille, String provenance, int force, int quantiteCreme) {
        super(nom, prix, taille, provenance, force);
        this.quantiteCreme = quantiteCreme;
    }

    public void allergie() {
        if (quantiteCreme > 0) {
            System.out.println("\t- Contient du lactose");
        }

    }

    @Override
    public String toString() {
        return super.toString() + " " + this.quantiteCreme + "cl de crème";
    }
}
