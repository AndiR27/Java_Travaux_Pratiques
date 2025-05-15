package CC01_Correction.Ex2;

import java.util.List;

public abstract class Covoiturage {
    private String id;
    private Conducteur conducteur;
    private List<Passager> passagers;
    private String origine;
    private String destination;
    private String heureDepart;
    private int placesDispo;
    private double prixParSiege;

    public Covoiturage(String id, Conducteur conducteur, List<Passager> passagers, String origine, String destination, String heureDepart, int placesDispo, double prixParSiege) {
        this.id = id;
        this.conducteur = conducteur;
        this.passagers = passagers;
        this.origine = origine;
        this.destination = destination;
        this.heureDepart = heureDepart;
        this.placesDispo = placesDispo;
        this.prixParSiege = prixParSiege;
    }

    /**
     * Ajoute un passager à la liste des passagers du covoiturage
     * @param passager Le passager à ajouter
     */
    public void addPassager(Passager passager) {
        if (placesDispo > 0) {
            passagers.add(passager);
            placesDispo--;
        } else {
            System.out.println("Aucune place disponible");
        }
    }
    public String getId() {
        return id;
    }

    public Conducteur getConducteur() {
        return conducteur;
    }

    public int getPlacesDispo() {
        return placesDispo;
    }

    public String getOrigine() {
        return origine;
    }

    public String getDestination() {
        return destination;
    }

    public void setPlacesDispo(int placesDispo) {
        this.placesDispo = placesDispo;
    }

    /**
     * Affiche la liste des passagers du covoiturage
     * @return Une chaîne de caractères contenant la liste des passagers
     */
    public String passagersListe(){
        String sb = "";
        sb += conducteur.toString() + " conduira les passagers suivants : ";
        for (Passager passager : passagers) {
            sb += "\n- " + passager.toString();
        }
        return sb;
    }
    @Override
    public String toString() {
        return " - ID:" + id + "\n Conducteur :" + conducteur + ", De " + origine + " à " + destination + "\n Heure de départ : " + heureDepart + "\n Places disponibles : " + placesDispo + "\n Prix par siège : " + prixParSiege;
    }
}
