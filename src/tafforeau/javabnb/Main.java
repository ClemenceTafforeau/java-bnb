package tafforeau.javabnb;

import tafforeau.javabnb.logements.Appartement;
import tafforeau.javabnb.logements.Logement;
import tafforeau.javabnb.logements.Maison;
import tafforeau.javabnb.outils.Utile;
import tafforeau.javabnb.reservations.*;
import tafforeau.javabnb.utilisateurs.Hote;
import tafforeau.javabnb.utilisateurs.Voyageur;

import java.util.Date;

public class Main {

    public static void main(String[] args) throws Exception {

        Hote personne1 = new Hote("Maxime", "Albert", 28, 3);
        Hote personne2 = new Hote("Jacques", "Dupont", 67, 6);
        Voyageur personne3 = new Voyageur("Laura", "Lenoir", 33);
        Voyageur personne4 = new Voyageur("Fabienne", "Carot", 57);

        Logement logement1 = new Maison(personne1, 128, "81 Rue Colbert, 37000 Tours", 140, 6, 260, true);
        Logement logement2 = new Appartement(personne2, 96, "72 Avenue Général de Gaulle, 72000 Le Mans", 62, 4, 4, 1);

        Date dateArrivee1 = Utile.creerDate(12,4,2026);
        Date dateArrivee2 = Utile.creerDate(24,5,2026);

        Sejour sejour1 = SejourFactory.createSejour(dateArrivee1, 4, logement2, 2);
        Sejour sejour2 = SejourFactory.createSejour(dateArrivee2, 8, logement1, 5);

        try {
            Reservation reservation1 = new Reservation(personne4, sejour1);
            Reservation reservation2 = new Reservation(personne3, sejour2);

            reservation1.afficher();
            reservation2.afficher();
        } catch (Exception exception) {
            System.err.println("Impossible de valider la réservation.");
            System.err.println(exception.getMessage());
        }
    }
}
