package TP09_Correction.Domaine;

public class Guerrier extends PersonnageJouable {
    private int resistanceDeBase;

    public Guerrier(String nom, int niveau, int pointsDeVie, int pointsDeMana, int pointsAttaque, int pointsDefense, int resistanceDeBase) {
        super(nom, niveau, pointsDeVie, pointsDeMana, pointsAttaque, pointsDefense);
        this.resistanceDeBase = resistanceDeBase;
    }


    @Override
    public void attaquer(PersonnageJouable personnage) {
        System.out.println(this.getNom() + " le guerrier attaque");
        personnage.recevoirDegats(this.getPointsAttaque());
    }

    @Override
    public void defendre() {
        System.out.println(this.getNom() + " le guerrier se défend");
        this.ajoutDefense(1+resistanceDeBase);
    }

    @Override
    public String toString() {
        return super.toString() + "guerrier";
    }

    @Override
    public void competenceSpeciale() {
        System.out.println(this.getNom() + " le guerrier utilise une compétence spéciale");
        this.ajoutDefense(this.getDefense() * 2);
    }
}
