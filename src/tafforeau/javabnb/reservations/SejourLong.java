package tafforeau.javabnb.reservations;

import tafforeau.javabnb.logements.Logement;

import java.util.Date;

public class SejourLong extends Sejour {

    private int PROMOTION_EN_POURCENTAGE = 20;
    private float promotion;

    // private int MIN_NUITS_POUR_PROMOTION;

    SejourLong(Date dateArrivee, int nbNuits, Logement logement, int nbVoyageurs) {
        super(dateArrivee, nbNuits, logement, nbVoyageurs);

        /* if (nbNuits < MIN_NUITS_POUR_PROMOTION) {
            throw new IllegalArgumentException(String.format("Un séjour long ne peut pas consister de moins de %s nuits", MIN_NUITS_POUR_PROMOTION));
        } */
    }

    @Override
    public boolean aUnNombreDeNuitsCorrect() {
        return this.getNbNuits() >= 6 && this.getNbNuits() <= 31;
    }

    @Override
    public void miseAJourDuPrixDuSejour() {
        this.promotion = calcPromotion();
        this.prix = Math.round(this.getLogement().getTarifParNuit() * this.getNbNuits() - this.promotion);

        System.out.printf("Le prix de ce séjour est de %s€%n", this.prix);
    }

    private float calcPromotion() {
        return this.prix * ((float) PROMOTION_EN_POURCENTAGE / 100);
    }

    public void afficher() {
        super.afficher();
        miseAJourDuPrixDuSejour();
    }
}
