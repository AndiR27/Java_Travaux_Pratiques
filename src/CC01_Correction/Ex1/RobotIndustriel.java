package CC01_Correction.Ex1;

import java.util.List;

public class RobotIndustriel extends RobotNettoyeur {

    public RobotIndustriel(List<String> programme) {
        super(programme);
    }

    @Override
    public void executerProgramme() {
        //On peut aussi lancer la methode en dessous avec comme paramètre "programme" de la classe mère
        aspirer();
        laver();
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
                case "retour":
                    retourBase();
                    break;
                default:
                    System.out.println("Instruction inconnue : " + instruction);
            }
        }
    }

    @Override
    public void aspirer() {
        System.out.println("Aspiration puissante industrielle.");
    }

    @Override
    public void laver() {
        System.out.println("Lavage haute pression.");
    }

    @Override
    public void desinfecter() {
        System.out.println("Désinfection chimique en profondeur.");
    }

    @Override
    public void retourBase() {
        System.out.println("Docking automatique industriel.");
    }

    @Override
    public void demarrer() {
        System.out.println("RobotIndustriel activé.");
    }

    @Override
    public void arreter() {
        System.out.println("RobotIndustriel désactivé.");
    }
}
