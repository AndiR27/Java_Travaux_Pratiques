package CC01_Correction.Ex2;

public class Passager extends Personne{
    private String numeroPassport;
    private String dateExpiration;

    public Passager(String nom, String prenom, String adresse, String telephone, String email, String numeroPassport, String dateExpiration) {
        super(nom, prenom, adresse, telephone, email);
        this.numeroPassport = numeroPassport;
        this.dateExpiration = dateExpiration;
    }

    public Passager(String prenom) {
        super(prenom);
    }
}
