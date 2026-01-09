package tafforeau.javabnb.logements;

import tafforeau.javabnb.utilisateurs.Hote;

public abstract class Logement {

    private Hote hote;
    private int tarifParNuit;
    private String adresse;
    private int superficie;
    private int nbVoyageursMax;

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

    public int getNbVoyageursMax() {

        return this.nbVoyageursMax;
    }

    public Hote getHote() {

        return this.hote;
    }

    public String getAdresse() {

        return this.adresse;
    }

    public int getSuperficie() {

        return this.superficie;
    }

    public abstract void afficher();
}
