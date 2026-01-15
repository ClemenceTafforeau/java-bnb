package tafforeau.javabnb;

import tafforeau.javabnb.logements.Logement;
import tafforeau.javabnb.outils.Comparateur;
import tafforeau.javabnb.outils.JavaBnBData;
import tafforeau.javabnb.recherche.Recherche;
import tafforeau.javabnb.reservations.*;
import tafforeau.javabnb.utilisateurs.Voyageur;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

public class Main {

    public static void main(String[] args) {

        Voyageur voyageur = new Voyageur("Fabienne", "Carot", 57);

        Date date = new Date(126, Calendar.MARCH, 12);
        int nbNuits = 12;
        int nbVoyageurs = 2;
        Logement logement = JavaBnBData.getInstance().getLogements().getFirst();
        Logement logement2 = JavaBnBData.getInstance().getLogements().getLast();

        Sejour sejour = SejourFactory.createSejour(date, nbNuits, logement, nbVoyageurs);

        Comparateur<Logement> comparateur = new Comparateur<>(logement, logement2);
        Logement plusCher = comparateur.getHigher();
        Logement moinsCher = comparateur.getLower();
//        plusCher.afficher();
//        moinsCher.afficher();

        try {
            Reservation reservation = new Reservation(voyageur, sejour);
//            reservation.afficher();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        Recherche recherche = new Recherche.Builder(2).possedePiscine(true).build();
        ArrayList<Logement> resultatRecherche = recherche.resultat();
        recherche.afficher(resultatRecherche);
    }
}
