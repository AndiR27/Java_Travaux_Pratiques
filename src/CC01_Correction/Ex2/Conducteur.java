package CC01_Correction.Ex2;

public class Conducteur extends Personne{
    private String permisConduire;
    private String typeVehicule;
    private String experience;
    private String dateObtentionPermis;

    public Conducteur(String nom, String prenom, String adresse, String telephone, String email, String permisConduire, String typeVehicule, String experience, String dateObtentionPermis) {
        super(nom, prenom, adresse, telephone, email);
        this.permisConduire = permisConduire;
        this.typeVehicule = typeVehicule;
        this.experience = experience;
        this.dateObtentionPermis = dateObtentionPermis;
    }

    public Conducteur(String prenom) {
        super(prenom);
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
