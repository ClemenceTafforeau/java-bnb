package tafforeau.javabnb;

import tafforeau.javabnb.logements.Logement;
import tafforeau.javabnb.outils.JavaBnBData;
import tafforeau.javabnb.reservations.*;
import tafforeau.javabnb.utilisateurs.Voyageur;

import java.util.Calendar;
import java.util.Date;

public class Main {

    public static void main(String[] args) {

        Voyageur voyageur = new Voyageur("Fabienne", "Carot", 57);

        Date date = new Date(126, Calendar.MARCH, 12);
        int nbNuits = 12;
        int nbVoyageurs = 2;
        Logement logement = JavaBnBData.getInstance().getLogements().getFirst();

        Sejour sejour = SejourFactory.createSejour(date, nbNuits, logement, nbVoyageurs);

        try {
            Reservation reservation = new Reservation(voyageur, sejour);
            reservation.afficher();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
