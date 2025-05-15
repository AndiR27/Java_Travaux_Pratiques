package CC01_Correction.Ex2;

import java.util.List;

public class CovoituragePremium extends Covoiturage{
    private int confortRating;

    public CovoituragePremium(String id, Conducteur conducteur, List<Passager> passagers, String origine, String destination, String heureDepart, int placesDispo, double prixParSiege, int confortRating) {
        super(id, conducteur, passagers, origine, destination, heureDepart, placesDispo, prixParSiege);
        this.confortRating = confortRating;
    }

    @Override
    public String toString() {
        return "Covoiturage Premium " + super.toString() + ", Confort: " + confortRating + "/5";
    }
}
