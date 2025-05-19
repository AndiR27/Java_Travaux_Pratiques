package TP09_Correction.Domaine;

public class Soigneur extends PersonnageJouable {

    private int recupPV;

    public Soigneur(String nom, int niveau, int pointsDeVie, int pointsDeMana, int pointsAttaque, int pointsDefense, int recupPV) {
        super(nom, niveau, pointsDeVie, pointsDeMana, pointsAttaque, pointsDefense);
        this.recupPV = recupPV;
    }

    private void recupPV(){
        this.setPointsDeVie(recupPV);
    }
    @Override
    public void attaquer(PersonnageJouable cible) {
        System.out.println(this.getNom() + " lance une attaque magique sur " + cible.getNom());
        cible.recevoirDegats(this.getPointsAttaque());
        recupPV();
    }

    @Override
    public void defendre() {
        System.out.println(this.getNom() + " se protège avec un bouclier magique");
        this.ajoutDefense(1);
        recupPV();
    }

    @Override
    public void competenceSpeciale() {
        System.out.println(this.getNom() + " se soigne");
        this.recevoirDegats(-10); // Utilise les points de mana pour soigner
        this.setPointsMana(10);
    }

    @Override
    public String toString() {
        return super.toString() + "soigneur";
    }
}
