package TP06;

public class Voiture extends Vehicule {


    private int chevaux;

    public Voiture(String marque, String modele, int annee, String plaqueImmatriculation, int anneeRevision, int chevaux) {
        super(marque, modele, annee, plaqueImmatriculation, anneeRevision);
        this.chevaux = chevaux;
    }

    @Override
    public String toString() {
        return super.toString() +
                "chevaux=" + chevaux +
                '}';
    }
}
