package CC01_Correction.Ex1;

import java.util.List;

public abstract class RobotNettoyeur implements ICleanable{
    private List<String> programme;

    public RobotNettoyeur(List<String> programme) {
        this.programme = programme;
    }

    public abstract void executerProgramme();
    public abstract void executerProgramme(List<String> programme);


    public abstract void aspirer();


    public abstract void laver();

    public abstract void desinfecter();

    public abstract void retourBase();


    public abstract void demarrer();


    public abstract void arreter();
}
