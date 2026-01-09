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
        this.voyageur = voyageur;
        this.objetReservable = objetReservable;
        this.dateDeReservation = Date.from(Instant.now());
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
