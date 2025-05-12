package TP08_Correction;

public class AnalyseVirale extends Analyse{

    private String nomVirus;
    private boolean valeurAnalyse;

    public AnalyseVirale(int analyseID, int patientID, int patientAge, String nomVirus, boolean valeurAnalyse) {
        super(analyseID, patientID, patientAge);
        this.nomVirus = nomVirus;
        this.valeurAnalyse = valeurAnalyse;
    }

    public boolean isProblematic() {
        return this.valeurAnalyse;
    }

    @Override
    public String toString() {
        String norme = "";
        if (isProblematic()){
            norme = "oui";
        }
        else {
            norme = "non";
        }
        return super.toString() + " Bilan Virus " + nomVirus + " " + norme;
    }
}
