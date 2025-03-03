package TP01_Correction.Exercice2;

public class Livre {
    // Vos attributs ici
    private int id;
    private String titre;
    private boolean dispo;

    public Livre(int id, String titre, boolean dispo) {
        this.id = id;
        this.titre = titre;
        this.dispo = dispo;
    }

    // Vos méthodes ici
    public int getId() {
        return id;
    }

    public String getTitre() {
        return titre;
    }

    public boolean isDisponible() {
        return dispo;
    }

    public void setDisponible(boolean dispo) {
        this.dispo = dispo;
    }

    @Override
    public String toString() {
        return "[" + id + "] " + titre + " - Disponible: " + dispo;
    }
}
