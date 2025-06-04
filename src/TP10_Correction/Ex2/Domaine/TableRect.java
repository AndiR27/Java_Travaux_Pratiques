package TP10_Correction.Ex2.Domaine;

public class TableRect extends Table {
    private int longueur;
    private int largeur;

    public TableRect(String code, int nbPlaces, Matiere matiere, int longueur, int largeur) {
        super(code, nbPlaces, matiere);
        this.longueur = longueur;
        this.largeur = largeur;
    }

    @Override
    public int surface() {
        return longueur * largeur;
    }

    @Override
    public String toString() {
        return "Table rectangle " + super.toString() + " de " + longueur + "x" + largeur;
    }
}