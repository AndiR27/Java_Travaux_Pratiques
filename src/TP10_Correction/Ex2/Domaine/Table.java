package TP10_Correction.Ex2.Domaine;

import java.util.Objects;

public abstract class Table implements Comparable<Table> {
    private String code;
    private int nbPlaces;
    private Matiere matiere;

    public abstract int surface();

    public Table(String code, int nbPlaces, Matiere matiere) {
        this.code = code;
        this.nbPlaces = nbPlaces;
        this.matiere = matiere;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Table table = (Table) o;
        return Objects.equals(code, table.code);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(code);
    }

    @Override
    public int compareTo(Table o) {
        return this.code.compareTo(o.code);
    }

    public int compareSurface(Table o) {
        return this.surface() - o.surface();
    }

    public boolean estEn(Matiere matiere) {
        return this.matiere.equals(matiere);
    }

    @Override
    public String toString() {
        return "(" + code + ") : " + nbPlaces + " places, en " + matiere;
    }
}