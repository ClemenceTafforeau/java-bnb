package tafforeau.javabnb.reservations;

import tafforeau.javabnb.logements.Logement;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class Sejour {

    private Date dateArrivee;
    private int nbNuits;
    private Logement logement;
    private int nbVoyageurs;

    private double tauxPromotion = 0.2;

    public Sejour(Date dateArrivee, int nbNuits, Logement logement, int nbVoyageurs) {
        setDateArrivee(dateArrivee);
        setNbNuits(nbNuits);
        setLogement(logement);
        setNbVoyageurs(nbVoyageurs);
    }

    public void setDateArrivee(Date dateArrivee) {
        this.dateArrivee = dateArrivee;
    }

    public void setNbNuits(int nbNuits) {
        this.nbNuits = nbNuits;
    }

    public void setLogement(Logement logement) {
        this.logement = logement;
    }

    public void setNbVoyageurs(int nbVoyageurs) {
        this.nbVoyageurs = nbVoyageurs;
    }

    public double calcPrixSejour(double tauxPromotion) {
        int tarifLogement = this.logement.getTarifParNuit();

        if (this.nbNuits > 5) {
            double promotion = tarifLogement * this.nbNuits * tauxPromotion;

            return tarifLogement * this.nbNuits - promotion;
        } else {
            return tarifLogement * this.nbNuits;
        }
    }

    public void afficher() {
        SimpleDateFormat dateFormatter = new SimpleDateFormat("dd/MM/yyyy", Locale.FRANCE);

        this.logement.afficher();
        System.out.println(String.format("La date d'arrivée est le %s pour %s nuits", dateFormatter.format(this.dateArrivee), this.nbNuits));
        System.out.println(String.format("Le prix de ce séjour est de %s€", calcPrixSejour(this.tauxPromotion)));
    }
}
