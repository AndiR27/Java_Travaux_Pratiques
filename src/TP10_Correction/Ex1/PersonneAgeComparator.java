package TP10_Correction.Ex1;

import java.util.Comparator;

public class PersonneAgeComparator implements Comparator<Personne> {
    @Override
    public int compare(Personne p1, Personne p2) {
        return Integer.compare(p1.getAge(), p2.getAge());
    }
}
