package tafforeau.javabnb.reservations;

import tafforeau.javabnb.logements.Logement;

import java.util.Date;

public final class SejourFactory {

    private SejourFactory(Date dateArrivee, int nbNuits, Logement logement, int nbVoyageurs) {
        throw new UnsupportedOperationException("Impossible d'instancier un patron de conception de type fabrique (factory)");
    }

    public static Sejour createSejour(Date dateArrivee, int nbNuits, Logement logement, int nbVoyageurs) {
        return nbNuits <= 5 ?
        new SejourCourt(dateArrivee, nbNuits, logement, nbVoyageurs) :
        new SejourLong(dateArrivee, nbNuits, logement, nbVoyageurs);
    }
}
