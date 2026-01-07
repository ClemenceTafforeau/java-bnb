package tafforeau.javabnb.logements;

import tafforeau.javabnb.utilisateurs.Personne;

public class Logement {

    private Personne hote;
    private int tarifParNuit;
    private String adresse;
    private int superficie;
    private int nbVoyageursMax;

    public Logement(Personne hote, int tarifParNuit, String adresse, int superficie, int nbVoyageursMax) {
        setHote(hote);
        setTarifParNuit(tarifParNuit);
        setAdresse(adresse);
        setSuperficie(superficie);
        setNbVoyageursMax(nbVoyageursMax);
    }

    public void setHote(Personne hote) {
        this.hote = hote;
    }

    public void setTarifParNuit(int tarifParNuit) {
        this.tarifParNuit = tarifParNuit;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public void setSuperficie(int superficie) {
        this.superficie = superficie;
    }

    public void setNbVoyageursMax(int nbVoyageursMax) {
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
