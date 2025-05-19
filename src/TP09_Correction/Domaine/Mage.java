package TP09_Correction.Domaine;


public class Mage extends PersonnageJouable{

    private int puissanceMagique;

    public Mage(String nom, int niveau, int pointsDeVie, int pointsDeMana, int pointsAttaque, int pointsDefense, int puissanceMagique) {
        super(nom, niveau, pointsDeVie, pointsDeMana, pointsAttaque, pointsDefense);
        this.puissanceMagique = puissanceMagique;
    }

    @Override
    public void attaquer(PersonnageJouable cible) {
        System.out.println(this.getNom() + " lance une attaque magique sur " + cible.getNom());
        cible.recevoirDegats(this.getPointsAttaque() + puissanceMagique);
    }

    @Override
    public void defendre() {
        System.out.println(this.getNom() + " se protège avec un bouclier magique");
        this.ajoutDefense(1);
    }

    @Override
    public void competenceSpeciale() {
        System.out.println(this.getNom() + " utilise un sort puissant");
        this.setAttaque(this.getPointsAttaque() * 2);
        this.setPointsMana(10);
    }
    @Override
    public String toString() {
        return super.toString() + "mage";
    }
}

