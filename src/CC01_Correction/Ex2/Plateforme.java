package CC01_Correction.Ex2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Plateforme implements IReservable {
    private Map<Integer, Covoiturage> covoiturages;
    private int id = 1;

    public Plateforme() {
        this.covoiturages = new HashMap<>();
    }

    /**
     * Ajoute un covoiturage à la plateforme.
     * @param c Le covoiturage à ajouter.
     */
    public void ajouterCovoiturage(Covoiturage c) {
        covoiturages.put(id, c);
        id++;
    }

    /**
     * Affiche tous les covoiturages disponibles sur la plateforme (on passe ici par le toString, on pourrait
     * aussi utiliser la methode afficherDetails...
     */
    public void afficherCovoiturages() {
        for (Integer id : covoiturages.keySet()) {
            System.out.println(covoiturages.get(id));
        }
    }

    /**
     * Charge les covoiturages à partir d'un fichier CSV.
     * @param chemin Le chemin du fichier CSV.
     */
    public void chargerCovoiturages(String chemin) {
        String[][] data = FileToStr.lireCsv(chemin);


            for (int ligne = 1 ; ligne < data.length; ligne++) {
                String type = data[ligne][0];
                String id = data[ligne][1];
                String driver = data[ligne][2];
                String origin = data[ligne][3];
                String destination = data[ligne][4];
                String heureDep = data[ligne][5];
                String siegesDispo = data[ligne][6];
                String prix = data[ligne][7];
                String noteConfort = data[ligne][8];
                List<Passager> passagers = new ArrayList<>();
                for (int i = 9; i < data[ligne].length; i++) {
                    passagers.add(new Passager(data[ligne][i]));
                }
                Covoiturage c = null;
                //Creation du covoiturage :
                if (type.equals("CovoiturageStandard")) {
                    c = new CovoiturageStandard(id, new Conducteur(driver), passagers, origin, destination, heureDep, Integer.parseInt(siegesDispo), Double.parseDouble(prix));
                } else if (type.equals("CovoituragePremium")) {
                    c = new CovoituragePremium(id, new Conducteur(driver), passagers, origin, destination, heureDep, Integer.parseInt(siegesDispo), Double.parseDouble(prix), Integer.parseInt(noteConfort));
                } else {
                    System.out.println("Type de covoiturage inconnu : " + type);
                    continue;
                }
                //Ajout du covoiturage à la plateforme :
                this.ajouterCovoiturage(c);
            }

    }

    /**
     * Réserve des places pour un covoiturage donné.
     * @param id L'identifiant du covoiturage.
     * @param passagers La liste des passagers à réserver.
     * @return true si la réservation a réussi, false sinon.
     */
    @Override
    public boolean reserver(String id, List<Passager> passagers) {
        //Covoiturage c = covoiturages.get(id) -> ne fonctionne pas, car on cherche selon l'id d'un covoiturage, pas l'id de la map
        Covoiturage c = null;
        for (Integer idMap : covoiturages.keySet()) {
            Covoiturage co = covoiturages.get(idMap);
            if (co.getId().equals(id)) {
                c = co;
                break;
            }
        }
        if (c == null) {
            System.out.println("Covoiturage non trouvé");
            return false;
        } else {

            if (c.getPlacesDispo() >= passagers.size()) {
                int nbPlacesAvant = c.getPlacesDispo();
                for (Passager passager : passagers) {
                    c.addPassager(passager);
                }
                int nbPlacesApres = c.getPlacesDispo();
                Conducteur conducteur = c.getConducteur();
                System.out.println("=> Nombres de places disponibles avant réservation : " + nbPlacesAvant);
                System.out.println("=> Nombres de places disponibles après réservation : " + nbPlacesApres);
                System.out.println("\n" + conducteur + " a reservé " + passagers.size() + " places pour le covoiturage " + c.getId() + " de " + c.getOrigine() + " à " + c.getDestination());
                System.out.println("\n " + c.passagersListe());
                return true;
            } else {
                System.out.println("Reservation impossible pour le trajet " + c.getId() + ": places dispos(" + c.getPlacesDispo() + ") insuffisantes" );
                return false;
            }

        }
    }
}
