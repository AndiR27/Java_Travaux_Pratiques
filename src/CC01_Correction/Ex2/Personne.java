package CC01_Correction.Ex2;

public abstract class Personne {
    private String nom;
    private String prenom;
    private String adresse;
    private String telephone;
    private String email;

    public Personne(String nom, String prenom, String adresse, String telephone, String email) {
        this.nom = nom;
        this.prenom = prenom;
        this.adresse = adresse;
        this.telephone = telephone;
        this.email = email;
    }

    public Personne(String prenom) {
        this.prenom = prenom;
    }

    @Override
    public String toString() {
        return prenom;
    }
}
