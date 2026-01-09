package tafforeau.javabnb.reservations;

import tafforeau.javabnb.logements.Logement;

import java.util.Date;

public class SejourLong extends Sejour {

    private int PROMOTION_EN_POURCENTAGE = 20;
    private double prix;
    private double promotion;

    private int MIN_NUITS_POUR_PROMOTION = super.getMinNuitsPourPromotion();
    private Logement logement = super.getLogement();
    private int nbNuits = super.getNbNuits();

    public SejourLong(Date dateArrivee, int nbNuits, Logement logement, int nbVoyageurs) {
        super(dateArrivee, nbNuits, logement, nbVoyageurs);

        if (nbNuits < MIN_NUITS_POUR_PROMOTION) {
            throw new IllegalArgumentException(String.format("Un séjour long ne peut pas consister de moins de %s nuits", MIN_NUITS_POUR_PROMOTION));
        }

        this.prix = calcPrixSejour();
    }

    private double calcPromotion() {
        return logement.getTarifParNuit() * this.nbNuits * ((double) PROMOTION_EN_POURCENTAGE / 100);
    }

    private double calcPrixSejour() {
        this.promotion = calcPromotion();

        return logement.getTarifParNuit() * this.nbNuits - this.promotion;
    }

    public void afficher() {
        super.afficher();
        System.out.printf("Le prix de ce séjour est de %s€%n", this.prix);
    }
}
