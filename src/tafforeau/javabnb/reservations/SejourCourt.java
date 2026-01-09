package tafforeau.javabnb.reservations;

import tafforeau.javabnb.logements.Logement;

import java.util.Date;

public class SejourCourt extends Sejour {

    private int prix;

    private Logement logement = super.getLogement();

    private int nbNuits = super.getNbNuits();
    private int MIN_NUITS_POUR_PROMOTION = super.getMinNuitsPourPromotion();

    public SejourCourt(Date dateArrivee, int nbNuits, Logement logement, int nbVoyageurs) {
        super(dateArrivee, nbNuits, logement, nbVoyageurs);

        if (nbNuits >= MIN_NUITS_POUR_PROMOTION) {
            throw new IllegalArgumentException(String.format("Un séjour court ne peut pas dépasser %s nuits", MIN_NUITS_POUR_PROMOTION - 1));
        }

        this.prix = calcPrixSejour();
    }

    private int calcPrixSejour() {
        return logement.getTarifParNuit() * this.nbNuits;
    }

    public void afficher() {
        super.afficher();
        System.out.printf("Le prix de ce séjour est de %s€%n", this.prix);
    }
}
