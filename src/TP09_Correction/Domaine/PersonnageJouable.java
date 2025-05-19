package TP09_Correction.Domaine;

public abstract class PersonnageJouable implements Action, ActionSpeciale{
    private String nom;
    private int niveau;
    private int pointsDeVie;
    private int pointsDeMana;
    private int pointsAttaque;
    private int pointsDefense;

    public PersonnageJouable(String nom, int niveau, int pointsDeVie, int pointsDeMana, int pointsAttaque, int pointsDefense) {
        this.nom = nom;
        this.niveau = niveau;
        this.pointsDeVie = pointsDeVie;
        this.pointsDeMana = pointsDeMana;
        this.pointsAttaque = pointsAttaque;
        this.pointsDefense = pointsDefense;
    }


    public String getNom() {
        return nom;
    }
    protected int getPointsAttaque() {
        return pointsAttaque;
    }

    public int getPointsDeVie() {
        return pointsDeVie;
    }
    protected void recevoirDegats(int degats) {
        degats = degats - this.pointsDefense;
        if (degats < 0) {
            degats = 0;
        }
        this.pointsDeVie -= degats;
    }

    protected void ajoutDefense(int def) {
        this.pointsDefense += def;
    }

    protected void setPointsMana(int i) {
        this.pointsDeMana -= i;
    }

    protected void setPointsDeVie(int recupPV) {
        this.pointsDeVie += recupPV;
    }

    @Override
    public String toString() {
        return nom + " est de niveau " + niveau + ", il s'agit d'un ";
    }

    protected int getDefense() {
        return pointsDefense;
    }

    public int getPointsMana() {
        return pointsDeMana;
    }

    protected void setAttaque(int i) {
        this.pointsAttaque = i;
    }
}
