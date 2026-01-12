package tafforeau.javabnb.reservations;

import tafforeau.javabnb.logements.Logement;

import java.util.Date;

public class SejourCourt extends Sejour {

    // private int MIN_NUITS_POUR_PROMOTION;

    SejourCourt(Date dateArrivee, int nbNuits, Logement logement, int nbVoyageurs) {
        super(dateArrivee, nbNuits, logement, nbVoyageurs);

        /* if (nbNuits >= MIN_NUITS_POUR_PROMOTION) {
            throw new IllegalArgumentException(String.format("Un séjour court ne peut pas dépasser %s nuits", MIN_NUITS_POUR_PROMOTION - 1));
        } */
    }

    @Override
    public void miseAJourDuPrixDuSejour() {
        this.prix = this.getLogement().getTarifParNuit() * this.getNbNuits();
        System.out.printf("Le prix de ce séjour est de %s€%n", this.prix);
    }

    @Override
    public boolean aUnNombreDeNuitsCorrect() {
        return this.getNbNuits() >= 1 && this.getNbNuits() < 6;
    }

    public void afficher() {
        super.afficher();
        miseAJourDuPrixDuSejour();
    }
}
