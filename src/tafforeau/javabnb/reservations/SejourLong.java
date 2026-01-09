package tafforeau.javabnb.reservations;

import tafforeau.javabnb.logements.Logement;

import java.util.Date;

public class SejourLong extends Sejour {

    private int PROMOTION_EN_POURCENTAGE = 20;
    private double promotion;

    private int prix = super.getPrix();
    private int nbNuits = super.getNbNuits();
    private int MIN_NUITS_POUR_PROMOTION = super.getMinNuitsPourPromotion();

    public SejourLong(Date dateArrivee, int nbNuits, Logement logement, int nbVoyageurs) {
        super(dateArrivee, nbNuits, logement, nbVoyageurs);

        if (nbNuits < MIN_NUITS_POUR_PROMOTION) {
            throw new IllegalArgumentException(String.format("Un séjour long ne peut pas consister de moins de %s nuits", MIN_NUITS_POUR_PROMOTION));
        }
    }

    @Override
    public boolean aUnNombreDeNuitsCorrect() {
        return this.nbNuits >= MIN_NUITS_POUR_PROMOTION && this.nbNuits <= 31;
    }

    private double calcPromotion() {
        return this.prix * ((double) PROMOTION_EN_POURCENTAGE / 100);
    }

    private double calcPrixSejour() {
        this.promotion = calcPromotion();

        return this.prix - this.promotion;
    }

    public void afficher() {
        String prixSejourArrondi = String.format("%.2f", calcPrixSejour());

        super.afficher();
        System.out.printf("Le prix de ce séjour est de %s€%n", prixSejourArrondi);
    }
}
