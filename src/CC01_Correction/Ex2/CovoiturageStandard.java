package CC01_Correction.Ex2;

import java.util.List;

public class CovoiturageStandard extends Covoiturage{

    public CovoiturageStandard(String id, Conducteur conducteur, List<Passager> passagers, String origine, String destination, String heureDepart, int placesDispo, double prixParSiege) {
        super(id, conducteur, passagers, origine, destination, heureDepart, placesDispo, prixParSiege);
    }

    @Override
    public String toString() {
        return "CovoiturageStandard " + super.toString();
    }
}
