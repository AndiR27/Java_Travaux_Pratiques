package TP08_Correction;

public abstract class Analyse {
    private int analyseID;
    private int patientID;

    private int patientAge;

    public Analyse(int analyseID, int patientID, int patientAge) {
        this.analyseID = analyseID;
        this.patientID = patientID;
        this.patientAge = patientAge;
    }

    public abstract boolean isProblematic();

    public int getPatientID() {
        return patientID;
    }

    public int getPatientAge() {
        return patientAge;
    }

    @Override
    public String toString() {
        return "Analyse " + analyseID + " pour patient " + patientID;
    }
}
