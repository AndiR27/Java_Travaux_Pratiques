package CC01_Correction.Ex1;

import java.util.ArrayList;
import java.util.List;

public class GestionRobots {
    public static void main(String[] args) {
        System.out.println("=== Programme Robot Éco ===");
        List<String> robotEcoProgramme = new ArrayList<>();
        robotEcoProgramme.add("aspirer");
        robotEcoProgramme.add("laver");
        robotEcoProgramme.add("désinfecter");
        robotEcoProgramme.add("retour_base");
        RobotNettoyeur robotEco = new RobotEco(robotEcoProgramme);
        robotEco.demarrer();
        robotEco.executerProgramme();
        robotEco.arreter();

        System.out.println("\n=== Programme Robot Industriel ===");
        List<String> robotIndustrielProgramme = new ArrayList<>();
        robotIndustrielProgramme.add("aspirer");
        robotIndustrielProgramme.add("laver");
        robotIndustrielProgramme.add("retour");
        RobotNettoyeur robotIndus = new RobotIndustriel(robotIndustrielProgramme);
        robotIndus.demarrer();
        robotIndus.executerProgramme();
        robotIndus.arreter();

        System.out.println("\n=== Programme Robot Industriel ===");
        List<String> robotIndustrielProgramme2 = new ArrayList<>();
        robotIndus.demarrer();
        robotIndustrielProgramme2.add("aspirer");
        robotIndustrielProgramme2.add("laver");
        robotIndustrielProgramme2.add("retour");
        robotIndustrielProgramme2.add("mauvaise instruction");
        robotIndus.executerProgramme(robotIndustrielProgramme2);
        robotIndus.arreter();
    }
}