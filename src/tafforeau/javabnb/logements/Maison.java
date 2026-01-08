package tafforeau.javabnb.logements;

import tafforeau.javabnb.outils.Utile;
import tafforeau.javabnb.utilisateurs.Hote;

public class Maison extends Logement {

    private int superficieJardin;
    private boolean possedePiscine;

    public Maison(Hote hote, int tarifParNuit, String adresse, int superficie, int nbVoyageursMax, int superficieJardin, boolean possedePiscine) {

        super(hote, tarifParNuit, adresse, superficie, nbVoyageursMax);
        this.superficieJardin = superficieJardin;
        this.possedePiscine = possedePiscine;
    }

    public void afficher() {
        this.hote.afficher();

        System.out.printf("Le logement est une maison située %s%n", this.adresse);
        System.out.printf("Superficie : %sm²%n", this.superficie);

        if (this.superficieJardin > 0) {
            System.out.printf("Jardin : %s (%sm²)%n", Utile.afficherPolarite(true), this.superficieJardin);
        } else {
            System.out.printf("Jardin : %s%n", Utile.afficherPolarite(false));
        }

        System.out.printf("Piscine : %s%n", Utile.afficherPolarite(possedePiscine));
    }
}
