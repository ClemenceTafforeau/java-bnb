package tafforeau.javabnb.logements;

import tafforeau.javabnb.outils.Utile;
import tafforeau.javabnb.utilisateurs.Hote;

public class Appartement extends Logement {

    private int superficieBalcon;
    private int numeroEtage;
    private Hote aHote = getHote();
    private String aAdresse = getAdresse();
    private int aSuperficie = getSuperficie();

    public Appartement(String nomLogement, Hote hote, int tarifParNuit, String adresse, int superficie, int nbVoyageursMax, int superficieBalcon, int numeroEtage) {

        super(nomLogement, hote, tarifParNuit, adresse, superficie, nbVoyageursMax);
        this.superficieBalcon = superficieBalcon;
        this.numeroEtage = numeroEtage;
    }

    public void afficher() {
        String etage = Utile.afficherEtage(this.numeroEtage);

        aHote.afficher();

        System.out.printf("Le logement est un appartement situé %s au %s%n", aAdresse, etage);
        System.out.printf("Superficie : %sm²%n", aSuperficie);
        System.out.printf("Tarif par nuit : %s€%n", this.getTarifParNuit());
        System.out.printf("Prix au m² : %s€%n", String.format("%.2f", this.getPrixAuMetreCarre()));

        if (this.superficieBalcon > 0) {
            System.out.printf("Balcon : %s (%sm²)%n", Utile.afficherPolarite(true), this.superficieBalcon);
        } else {
            System.out.printf("Balcon : %s%n", Utile.afficherPolarite(false));
        }
    }
}
