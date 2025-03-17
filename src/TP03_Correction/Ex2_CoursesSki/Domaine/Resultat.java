package TP03_Correction.Ex2_CoursesSki.Domaine;

import java.util.Objects;

public class Resultat {
    private int dossard;
    private double temps;

    public Resultat(int dossard, double temps) {
        this.dossard = dossard;
        this.temps = temps;
    }

    public boolean comparerTemps(Resultat plusRapide) {
        return this.temps < plusRapide.temps;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Resultat resultat = (Resultat) o;
        return dossard == resultat.dossard;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(dossard);
    }

    @Override
    public String toString() {
        return "Dossard " + dossard + " : " + temps;
    }


}
