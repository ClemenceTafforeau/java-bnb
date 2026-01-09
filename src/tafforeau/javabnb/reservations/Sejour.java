package tafforeau.javabnb.reservations;

import tafforeau.javabnb.logements.Logement;
import tafforeau.javabnb.outils.Utile;

import java.time.Instant;
import java.util.Date;

public class Sejour implements Reservable {

    private Date dateArrivee;
    private int nbNuits;
    private Logement logement;
    private int nbVoyageurs;
    private int MIN_NUITS_POUR_PROMOTION = 6;

    public Sejour(Date dateArrivee, int nbNuits, Logement logement, int nbVoyageurs) {
        this.dateArrivee = dateArrivee;
        this.nbNuits = nbNuits;
        this.logement = logement;
        this.nbVoyageurs = nbVoyageurs;
    }

    // Implémentation de l'interface Reservable
    @Override
    public boolean aUneDateArriveeCorrecte() {
        return this.dateArrivee.compareTo(Date.from(Instant.now())) > 0;
    }

    @Override
    public boolean aUnNombreDeNuitsCorrect() {
        return this.nbNuits >= 1 && this.nbNuits <= 31;
    }

    @Override
    public boolean aUnNombreDeVoyageursCorrect() {
        return this.nbVoyageurs <= this.logement.getNbVoyageursMax();
    }

    public void afficher() {
        String dateArriveeStr = Utile.formaterDate(this.dateArrivee);

        this.logement.afficher();
        System.out.println(String.format("La date d'arrivée est le %s pour %s nuits", dateArriveeStr, this.nbNuits));
    }

    // Getters
    public int getMinNuitsPourPromotion() {
        return this.MIN_NUITS_POUR_PROMOTION;
    }

    public Date getDateArrivee() {
        return this.dateArrivee;
    }

    public int getNbNuits() {
        return this.nbNuits;
    }

    public Logement getLogement() {
        return this.logement;
    }

    public int getNbVoyageurs() {
        return this.nbVoyageurs;
    }

    // Setters
    public void setLogement(Logement logement) {
        this.logement = logement;
    }
}
