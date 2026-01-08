package tafforeau.javabnb.logements;

import tafforeau.javabnb.utilisateurs.Hote;

public class Logement {

    protected Hote hote;
    protected int tarifParNuit;
    protected String adresse;
    protected int superficie;
    protected int nbVoyageursMax;

    public Logement(Hote hote, int tarifParNuit, String adresse, int superficie, int nbVoyageursMax) {
        this.hote = hote;
        this.tarifParNuit = tarifParNuit;
        this.adresse = adresse;
        this.superficie = superficie;
        this.nbVoyageursMax = nbVoyageursMax;
    }

    public int getTarifParNuit() {
        return this.tarifParNuit;
    }

    public void afficher() {
        hote.afficher();
        System.out.println(String.format("Le logement est situé %s", this.adresse));
        System.out.println(String.format("Superficie : %sm²", this.superficie));
    }
}
