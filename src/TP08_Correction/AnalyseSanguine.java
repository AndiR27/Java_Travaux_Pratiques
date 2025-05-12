package TP08_Correction;

public class AnalyseSanguine extends Analyse{

    private String typeAnalyse;
    private int valeurAnalyse;

    public AnalyseSanguine(int analyseID, int patientID,int patientAge, String typeAnalyse, int valeurAnalyse) {
        super(analyseID, patientID, patientAge);
        this.typeAnalyse = typeAnalyse;
        this.valeurAnalyse = valeurAnalyse;
    }

    public boolean isProblematic() {
        if (this.getPatientAge() >= 5 && this.getPatientAge() <= 10) {
            if (this.typeAnalyse.equals("plaquettes") && (this.valeurAnalyse < 160000 || this.valeurAnalyse > 450000)) {
                return true;
            }
        } else if (this.getPatientAge() >= 11 && this.getPatientAge() <= 15) {
            if (this.typeAnalyse.equals("plaquettes") && (this.valeurAnalyse < 160000 || this.valeurAnalyse > 400000)) {
                return true;
            }
        } else {
            if (this.typeAnalyse.equals("plaquettes") && (this.valeurAnalyse < 160000 || this.valeurAnalyse > 350000)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public String toString() {
        String norme = "";
        if (isProblematic()){
            norme = "PAS DANS LA NORME";
        }
        return super.toString() + " Bilan Plaquettes, valeur " + valeurAnalyse + " " + norme;
    }
}
