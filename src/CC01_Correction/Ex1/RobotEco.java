package CC01_Correction.Ex1;

import java.util.List;

public class RobotEco extends RobotNettoyeur {

    public RobotEco(List<String> programme) {
        super(programme);
    }

    @Override
    public void executerProgramme() {
        aspirer();
        laver();
        desinfecter();
        retourBase();
    }

    @Override
    public void executerProgramme(List<String> programme) {
        for(String instruction : programme){
            switch (instruction) {
                case "aspirer":
                    aspirer();
                    break;
                case "laver":
                    laver();
                    break;
                case "desinfecter":
                    desinfecter();
                    break;
                case "retour_base":
                    retourBase();
                    break;
                default:
                    System.out.println("Instruction inconnue : " + instruction);
            }
        }
    }

    @Override
    public void aspirer() {
        System.out.println("Aspiration éco avec faible consommation.");
    }

    @Override
    public void laver() {
        System.out.println("Lavage éco avec peu d'eau.");
    }

    @Override
    public void desinfecter() {
        System.out.println("Désinfection à la vapeur.");
    }

    @Override
    public void retourBase() {
        System.out.println("Retour silencieux à la base.");
    }

    @Override
    public void demarrer() {
        System.out.println("RobotEco prêt à nettoyer.");
    }

    @Override
    public void arreter() {
        System.out.println("RobotEco arrêté.");
    }
}
