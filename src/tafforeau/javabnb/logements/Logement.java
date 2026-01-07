package tafforeau.javabnb.logements;

import tafforeau.javabnb.utilisateurs.Personne;

public class Logement {

    private Personne hote;
    private int tarifParNuit;
    private String adresse;
    private int superficie;
    private int nbVoyageursMax;

    public Logement(Personne hote, int tarifParNuit, String adresse, int superficie, int nbVoyageursMax) {
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
