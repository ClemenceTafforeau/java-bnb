package tafforeau.javabnb;

import tafforeau.javabnb.logements.Logement;
import tafforeau.javabnb.outils.Utile;
import tafforeau.javabnb.reservations.Sejour;
import tafforeau.javabnb.utilisateurs.Personne;

import java.text.ParseException;
import java.util.Date;

public class Main {

    public static void main(String[] args) throws ParseException {

        Personne personne1 = new Personne("Maxime", "Albert", 28);
        Personne personne2 = new Personne("Jacques", "Dupont", 67);
        Personne personne3 = new Personne("Laura", "Lenoir", 33);

        Logement logement1 = new Logement(personne1, 128, "81 Rue Colbert, 37000 Tours", 140, 6);
        Logement logement2 = new Logement(personne2, 96, "72 Avenue Général de Gaulle, 72000 Le Mans", 62, 4);
        Logement logement3 = new Logement(personne3, 62, "12 Boulevard Heurteloup, 37000 Tours", 40, 2);

        Date dateArrivee1 = Utile.creerDate(12,4,2026);

        Sejour sejour1 = new Sejour(dateArrivee1, 7, logement2, 3);

//        personne1.afficher();
//        personne2.afficher();
//        personne3.afficher();
//
//        logement1.afficher();
//        logement2.afficher();
//        logement3.afficher();

        sejour1.afficher();
    }
}
