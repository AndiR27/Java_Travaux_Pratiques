package TP02_Correction.Exercice2;

public class Personne {
    private String nom;
    private String prenom;
    private int age;
    private Ecole ecole;

    public Personne(String nom, String prenom, int age, Ecole ecole) {
        this.nom = nom;
        this.prenom = prenom;
        this.age = age;
        this.ecole = ecole;
    }

    //Pas très claire ici au niveau de la gestion de la fonction afficherNomEcole(),
    // mais on préfère faire en sorte que la methode retourne du string ce qui aurait
    //plus de sens, mais ne respecterait pas l'énoncé (en CC, ce genre de fonction sera plus implicite, soit
    //elle retourne qqchose, soit elle affiche, mais pas les deux)
    public String afficherNomEcole() {
        return "l'école se nomme " + ecole.getNom();
    }


    public String afficherEcole(){
        return this.ecole.toString();
    }

    @Override
    public String toString(){
        String affichage = "\n";

        //On ajoute d'abord les infos de base de l'étudiant :
        affichage += "Nom : " + this.nom + "\nPrénom : " + this.prenom + "\nAge : " + this.age + "\n";

        if(this.ecole.getType().equals("Publique")){
            affichage += this.ecole.toString();
            if(this.ecole.getDegree().equals("Tertiaire")){
                affichage += "\nIl s'agit d'un étudiant dans le niveau tertiaire";}
            return affichage;
        }
        else if(this.ecole.getType().equals("Privée")){
            affichage += "L'école est privée\n";
            affichage += afficherNomEcole();
            return affichage;
        }
        return affichage;
    }
}
