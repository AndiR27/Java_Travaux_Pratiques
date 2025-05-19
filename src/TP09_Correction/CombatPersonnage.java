package TP09_Correction;

import TP09_Correction.Domaine.*;

public class CombatPersonnage {

    private PersonnageJouable personnage1;
    private PersonnageJouable personnage2;

    public CombatPersonnage(PersonnageJouable personnage1, PersonnageJouable personnage2) {
        this.personnage1 = personnage1;
        this.personnage2 = personnage2;
    }

    /**
     * Méthode qui simule un combat entre deux personnages
     * @throws Exception si le combat dure plus de 10 tours
     */
    public void combat() throws Exception {
        int tour = 0;


        while (personnage1.getPointsDeVie() > 0 && personnage2.getPointsDeVie() > 0) {

            tour();
            tour++;
            if (tour > 10) {
                throw new Exception("Le combat est trop long et a duré plus de 10 tours. Match nul !");
            }
        }
        System.out.println("Fin du combat");
        if (personnage1.getPointsDeVie() <= 0) {
            System.out.println("Victoire de " + personnage2.getNom());
        } else {
            System.out.println("Victoire de " + personnage1.getNom());
        }
    }

    /**
     * Méthode qui simule un tour de combat
     */
    private void tour(){
        int action = (int) (Math.random() * 3);
        //personnage1
        actionTour(personnage1, action, personnage2);
        //personnage2
        int action2 = (int) (Math.random() * 3);
        actionTour(personnage2, action2, personnage1);
    }

    /**
     * Méthode qui simule une action d'un personnage
     * @param personnage personnage qui effectue l'action
     * @param action action à effectuer (0 = attaquer, 1 = défendre, 2 = compétence spéciale)
     * @param cible personnage cible de l'action
     */
    private void actionTour(PersonnageJouable personnage, int action, PersonnageJouable cible){
        switch (action){
            case 0:
                personnage.attaquer(cible);
                break;
            case 1:
                personnage.defendre();
                break;
            case 2:
                personnage.competenceSpeciale();
                break;
        }
    }

    @Override
    public String toString() {
        return "Combat entre les deux personnages suivants : \n" + personnage1 + "\nVS\n" + personnage2+"\n";
    }
}
