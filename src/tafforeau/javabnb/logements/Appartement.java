package tafforeau.javabnb.logements;

import tafforeau.javabnb.outils.Utile;
import tafforeau.javabnb.utilisateurs.Hote;

public class Appartement extends Logement {

    private int superficieBalcon;
    private int numeroEtage;

    public Appartement(Hote hote, int tarifParNuit, String adresse, int superficie, int nbVoyageursMax, int superficieBalcon, int numeroEtage) {

        super(hote, tarifParNuit, adresse, superficie, nbVoyageursMax);
        this.superficieBalcon = superficieBalcon;
        this.numeroEtage = numeroEtage;
    }

    public void afficher() {
        String etage = Utile.afficherEtage(this.numeroEtage);

        this.hote.afficher();

        System.out.printf("Le logement est un appartement situé %s au %s%n", this.adresse, etage);
        System.out.printf("Superficie : %sm²%n", this.superficie);

        if (this.superficieBalcon > 0) {
            System.out.printf("Balcon : %s (%sm²)%n", Utile.afficherPolarite(true), this.superficieBalcon);
        } else {
            System.out.printf("Balcon : %s%n", Utile.afficherPolarite(false));
        }
    }
}
