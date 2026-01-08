package tafforeau.javabnb;

import tafforeau.javabnb.logements.Appartement;
import tafforeau.javabnb.logements.Logement;
import tafforeau.javabnb.logements.Maison;
import tafforeau.javabnb.outils.Utile;
import tafforeau.javabnb.reservations.Sejour;
import tafforeau.javabnb.utilisateurs.Hote;

import java.text.ParseException;
import java.util.Date;

public class Main {

    public static void main(String[] args) throws ParseException {

        Hote personne1 = new Hote("Maxime", "Albert", 28, 3);
        Hote personne2 = new Hote("Jacques", "Dupont", 67, 6);
        Hote personne3 = new Hote("Laura", "Lenoir", 33, 1);

        Logement logement1 = new Maison(personne1, 128, "81 Rue Colbert, 37000 Tours", 140, 6, 260, true);
        Logement logement2 = new Appartement(personne2, 96, "72 Avenue Général de Gaulle, 72000 Le Mans", 62, 4, 4, 1);
        Logement logement3 = new Logement(personne3, 62, "12 Boulevard Heurteloup, 37000 Tours", 40, 2);

        Date dateArrivee1 = Utile.creerDate(12,4,2026);
        Date dateArrivee2 = Utile.creerDate(24,5,2026);

        Sejour sejour1 = new Sejour(dateArrivee1, 7, logement2, 3);
        Sejour sejour2 = new Sejour(dateArrivee2, 3, logement1, 5);

        sejour1.afficher();
        sejour2.afficher();
    }
}
