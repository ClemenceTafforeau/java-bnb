package tafforeau.javabnb.logements;

import tafforeau.javabnb.utilisateurs.Hote;

import tafforeau.javabnb.outils.Comparable;

public abstract class Logement implements Comparable<Logement> {

    private String nomLogement;
    private Hote hote;
    private int tarifParNuit;
    private String adresse;
    private int superficie;
    private int nbVoyageursMax;

    public Logement(String nomLogement, Hote hote, int tarifParNuit, String adresse, int superficie, int nbVoyageursMax) {
        this.nomLogement = nomLogement;
        this.hote = hote;
        this.tarifParNuit = tarifParNuit;
        this.adresse = adresse;
        this.superficie = superficie;
        this.nbVoyageursMax = nbVoyageursMax;
    }

    public String getNomLogement() {

        return this.nomLogement;
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

    public double getPrixAuMetreCarre() {
        return (double) this.tarifParNuit / this.superficie;
    }

    public abstract void afficher();

    @Override
    public boolean isHigher(Logement pLogement) {
        return this.getTarifParNuit() > pLogement.getTarifParNuit();
    }

    @Override
    public boolean isLower(Logement pLogement) {
        return this.getTarifParNuit() < pLogement.getTarifParNuit();
    }
}
