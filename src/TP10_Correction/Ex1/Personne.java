package TP10_Correction.Ex1;

public class Personne implements Comparable<Personne> {
    private String nom;
    private int age;

    public Personne(String nom, int age) {
        this.nom = nom;
        this.age = age;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }


    @Override
    public int compareTo(Personne o) {
        return this.nom.compareTo(o.nom);
    }

    @Override
    public String toString() {
        return nom + " (" + age + " ans)";
    }
}
