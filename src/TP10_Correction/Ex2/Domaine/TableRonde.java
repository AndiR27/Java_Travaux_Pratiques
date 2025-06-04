package TP10_Correction.Ex2.Domaine;

public class TableRonde extends Table {
    private int diametre;

    public TableRonde(String code, int nbPlaces, Matiere matiere, int diametre) {
        super(code, nbPlaces, matiere);
        this.diametre = diametre;
    }

    @Override
    public int surface() {
        return (int) (Math.PI * (diametre / 2) * (diametre / 2));
    }

    @Override
    public String toString() {
        return "Table ronde " + super.toString() + " de diamètre " + diametre;
    }
}