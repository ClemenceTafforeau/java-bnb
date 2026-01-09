package tafforeau.javabnb.reservations;

import tafforeau.javabnb.outils.Utile;
import tafforeau.javabnb.utilisateurs.Voyageur;

import java.time.Instant;
import java.util.Date;

public class Reservation {

    private Reservable objetReservable;
    private Voyageur voyageur;
    private Date dateDeReservation;

    public Reservation(Voyageur voyageur, Reservable objetReservable) {
        try {
            validerReservation(objetReservable);

            this.voyageur = voyageur;
            this.objetReservable = objetReservable;
            this.dateDeReservation = Date.from(Instant.now());
        } catch (Exception exception) {
            System.err.println("Impossible de valider la réservation.");
            throw exception;
        }

    }

    /**
     * Vérifie que la réservation soit valide selon des critères prédéfinis :
     *
     * @exception IllegalArgumentException si la date d'arrivée est inférieure à la date du jour
     * @exception IllegalArgumentException si le nombre de nuits est inférieur à 1 ou supérieur à 31
     * @exception IllegalArgumentException si le nombre de voyageurs est supérieur au seuil autorisé pour le logement visé par la réservation
     */
    public void validerReservation(Reservable pObjetReservable) throws IllegalArgumentException {
        if (!pObjetReservable.aUneDateArriveeCorrecte()) {
            throw new IllegalArgumentException("La date d'arrivée doit être supérieure à la date du jour.");
        }

        if (!pObjetReservable.aUnNombreDeNuitsCorrect()) {
            throw new IllegalArgumentException("Un séjour doit consister en une nuit au minimum et 31 nuits au maximum.");
        }

        if (!pObjetReservable.aUnNombreDeVoyageursCorrect()) {
            throw new IllegalArgumentException("Vous ne pouvez pas réserver un logement si le nombre de voyageurs dépasse le seuil autorisé pour ce logement.");
        }
    }

    public void afficher() {
        String dateStr = Utile.formaterDate(dateDeReservation);

        System.out.printf("Date de la réservation : %s%n", dateStr);
        System.out.printf("Voyageur : ");
        voyageur.afficher();
        System.out.printf("%nA réservé chez ");
        objetReservable.afficher();
    }
}
