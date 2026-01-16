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

        Recherche recherche = new Recherche.Builder(2).build();
        ArrayList<Logement> resultatRecherche = recherche.resultat();
        // recherche.afficher(resultatRecherche);

        System.out.println("1 - Récupérez la liste des noms de tous les logements (fonction map)");
        recherche.afficherListeNomLogements(resultatRecherche);

        System.out.println("2 - Affichez le tarif moyen des logements du résultat (average)");
        recherche.afficherTarifMoyenLogements(resultatRecherche);

        System.out.println("3 - Affichez le délai de réponse moyen des hôtes (attention au doublons)");
        recherche.afficherDelaiReponseMoyen(resultatRecherche);

        System.out.println("4 - Affichez le logement avec la plus grande capacité de voyageurs (fonction max)");
        recherche.afficherPlusGrandeCapaciteVoyageurs(resultatRecherche);

        System.out.println("5 - Triez les logements par ordre croissant selon leur prix au mètre carré (fonction sorted)");
        recherche.afficherTriParPrixAuMetreCarre(resultatRecherche);

        System.out.println("6 - Comptez le nombre de maisons avec jardin");
        recherche.afficherNbMaisonsAvecJardin(resultatRecherche);

        System.out.println("7 - Affichez le nombre de logements par hôtes");
        recherche.afficherNbLogementsParHote(resultatRecherche);
    }
}
