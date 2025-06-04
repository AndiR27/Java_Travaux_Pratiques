package TP10_Correction.Ex1;

import java.util.Comparator;

public class ComparatorPersonneNomDesc implements Comparator<Personne> {
    @Override
    public int compare(Personne o1, Personne o2) {
        int res = o1.compareTo(o2);
        return res * -1;
    }
}
