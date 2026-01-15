package tafforeau.javabnb.recherche;

import tafforeau.javabnb.logements.Logement;
import tafforeau.javabnb.logements.Maison;
import tafforeau.javabnb.outils.JavaBnBData;

import java.util.ArrayList;
import java.util.stream.Collectors;

public class Recherche {
    private final int nbVoyageurs;
    private final int tarifMinParNuit;
    private final int tarifMaxParNuit;
    private final int possedePiscine;

    private final static int EXCLUS = 1;
    private final static int INCLUS = 2;

    private Recherche (Builder builder) {
        this.nbVoyageurs = builder.nbVoyageurs;
        this.tarifMinParNuit = builder.tarifMinParNuit;
        this.tarifMaxParNuit = builder.tarifMaxParNuit;
        this.possedePiscine = builder.possedePiscine;
    }

    public static class Builder {
        private final int nbVoyageurs;
        private int tarifMinParNuit;
        private int tarifMaxParNuit;
        private int possedePiscine;

        public Builder(int nbVoyageurs) {
            this.nbVoyageurs = nbVoyageurs;
        }

        public Builder tarifMinParNuit(int tarifMinParNuit) {
            this.tarifMinParNuit = tarifMinParNuit;
            return this;
        }

        public Builder tarifMaxParNuit(int tarifMaxParNuit) {
            this.tarifMaxParNuit = tarifMaxParNuit;
            return this;
        }

        public Builder possedePiscine(boolean possedePiscine) {
            this.possedePiscine = possedePiscine ? Recherche.INCLUS : Recherche.EXCLUS;

            return this;
        }

        public Recherche build() {
            return new Recherche(this);
        }
    }

    public boolean isInferieurTarifMax(Logement logement) {
        return logement.getTarifParNuit() <= this.tarifMaxParNuit;
    }

    public boolean isSuperieurTarifMin(Logement logement) {
        return logement.getTarifParNuit() >= this.tarifMinParNuit;
    }

    public ArrayList<Logement> resultat() {
        ArrayList<Logement> logementArrayList = JavaBnBData.getInstance().getLogements();

        logementArrayList = logementArrayList.stream()
                .filter(l -> this.nbVoyageurs < l.getNbVoyageursMax())
                .collect(Collectors.toCollection(ArrayList::new));

        if (this.tarifMaxParNuit != 0) {
            logementArrayList = logementArrayList.stream()
                    .filter(this::isInferieurTarifMax)
                    .collect(Collectors.toCollection(ArrayList::new));
        }

        if (this.tarifMinParNuit != 0) {
            logementArrayList = logementArrayList.stream()
                    .filter(this::isSuperieurTarifMin)
                    .collect(Collectors.toCollection(ArrayList::new));
        }

        if (this.possedePiscine != 0) {
            logementArrayList = logementArrayList.stream()
                    .filter(l -> l instanceof Maison)
                    .collect(Collectors.toCollection(ArrayList::new));

            if (this.possedePiscine == EXCLUS) {
                logementArrayList = logementArrayList.stream()
                        .filter(l -> !((Maison) l).getPossedePiscine())
                        .collect(Collectors.toCollection(ArrayList::new));
            } else if (this.possedePiscine == INCLUS) {
                logementArrayList = logementArrayList.stream()
                        .filter(l -> ((Maison) l).getPossedePiscine())
                        .collect(Collectors.toCollection(ArrayList::new));
            }
        }

        return logementArrayList.stream()
                .sorted((a, b) -> a.getTarifParNuit() - b.getTarifParNuit())
                // Pour info: Can be replaced with 'Comparator.comparingInt'
                .collect(Collectors.toCollection(ArrayList::new));
    }

    public void afficher(ArrayList<Logement> liste) {
        for (Logement logement: liste) {
            logement.afficher();
        }
    }
}
