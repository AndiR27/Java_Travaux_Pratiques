package TP05_Correction;

public class Chocolat extends Boisson{

    private String typeChocolat;

    public Chocolat(String nom, Double prix, int taille, String typeChocolat) {
        super(nom, prix, taille);
        this.typeChocolat = typeChocolat;
    }

    public String getTypeChocolat() {
        return typeChocolat;
    }


    @Override
    public void allergie() {
        if (!typeChocolat.equals("noir")) {
            System.out.println("\t- Contient du lactose");
        }

    }

    @Override
    public String toString() {
        return super.toString() + " " + this.typeChocolat;
    }
}
