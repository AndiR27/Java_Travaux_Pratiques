package CC01_Correction.Ex2;

import java.util.ArrayList;

public class GestionPlateforme {
    /**
     * Classe principale de l'application
     * @author (votre nom)
     * @version (un numéro de version ou une date)
     */
    public static void main(String[] args) {
        Plateforme plateforme = new Plateforme();

        // Option A: Charger les covoiturages depuis le fichier CSV
        plateforme.chargerCovoiturages("src/CC01_Correction/Ex2/covoiturages.csv");

        // Option B (fallback):
        // En cas de problème avec le CSV ou votre méthode de chargement de trajets de covoiturage:
        // 1) décommentez le bloc suivant (lignes 21-23)
        // 2) commentez le bloc ci-dessus (ligne 13)

        /*
        plateforme.ajouterCovoiturage(new CovoiturageStandard("C001", new Conducteur("Alice"), "Geneve", "Lausanne", "2025-07-15 08:00", 3, 15.0));
        plateforme.ajouterCovoiturage(new CovoituragePremium("C002", new Conducteur("Bob"), "Geneve", "Fribourg", "2025-07-15 09:30", 2, 20.0, 5));
        plateforme.ajouterCovoiturage(new CovoiturageStandard("C003", new Conducteur("Carole"), "Lausanne", "Yverdon", "2025-07-16 07:45", 4, 12.5));
        */

        // Affichage des trajets
        System.out.println("Affichage de l'ensemble des covoiturages :");
        plateforme.afficherCovoiturages();
        System.out.println();

        // Test de réservation
        System.out.println("Réservation de 2 places pour le covoiturage C002 :");
        ArrayList<Passager> passagersC002 = new ArrayList<>();
        passagersC002.add(new Passager("Jean-Remy"));
        passagersC002.add(new Passager("B2oBA"));
        plateforme.reserver("C002", passagersC002);
        System.out.println();

        // Test de réservation
        System.out.println("Réservation de 2 places pour le covoiturage C006 :");
        ArrayList<Passager> passagersC006 = new ArrayList<>();
        passagersC006.add(new Passager("Valerie"));
        passagersC006.add(new Passager("Jacob"));
        plateforme.reserver("C006", passagersC006);
        System.out.println();
    }
}