package tafforeau.javabnb.recherche;

import tafforeau.javabnb.logements.Logement;
import tafforeau.javabnb.logements.Maison;
import tafforeau.javabnb.outils.JavaBnBData;
import tafforeau.javabnb.outils.Utile;
import tafforeau.javabnb.utilisateurs.Hote;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

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
        Stream<Logement> logementStream = logementArrayList.stream();

        logementStream = logementStream
                .filter(l -> this.nbVoyageurs < l.getNbVoyageursMax());

        if (this.tarifMaxParNuit != 0) {
            logementStream = logementStream
                    .filter(this::isInferieurTarifMax);
        }

        if (this.tarifMinParNuit != 0) {
            logementStream = logementStream
                    .filter(this::isSuperieurTarifMin);
        }

        if (this.possedePiscine != 0) {
            logementStream = logementStream
                    .filter(l -> l instanceof Maison);

            if (this.possedePiscine == EXCLUS) {
                logementStream = logementStream
                        .filter(l -> !((Maison) l).getPossedePiscine());
            } else if (this.possedePiscine == INCLUS) {
                logementStream = logementStream
                        .filter(l -> ((Maison) l).getPossedePiscine());
            }
        }

        return logementStream
                .sorted((a, b) -> a.getTarifParNuit() - b.getTarifParNuit())
                // Pour info: Can be replaced with 'Comparator.comparingInt'
                .collect(Collectors.toCollection(ArrayList::new));
    }

    // Getters

    public ArrayList<String> getListeNomsLogements(ArrayList<Logement> listeLogements) {
        return listeLogements.stream()
                .map(Logement::getNomLogement)
                .collect(Collectors.toCollection(ArrayList::new));
    }

    public OptionalDouble getTarifMoyenLogements(ArrayList<Logement> listeLogements) {
        return listeLogements.stream()
                .mapToInt(Logement::getTarifParNuit)
                .average();
    }

    public OptionalDouble getDelaiReponseMoyen(ArrayList<Logement> listeLogements) {
        return listeLogements.stream()
                .filter(Utile.distinctByKey(Logement::getHote))
                .mapToInt(l -> l.getHote().getDelaiDeReponse())
                .average();
    }

    public OptionalInt getPlusGrandeCapaciteVoyageurs(ArrayList<Logement> listeLogements) {
        return listeLogements.stream()
                .mapToInt(Logement::getNbVoyageursMax)
                .max();
    }

    public ArrayList<Logement> getLogementsTriesParPrixAuMetreCarre(ArrayList<Logement> listeLogements) {
        return listeLogements.stream()
                .sorted(Comparator.comparingDouble(Logement::getPrixAuMetreCarre))
                .collect(Collectors.toCollection(ArrayList::new));
    }

    public long getNbMaisonsAvecJardin(ArrayList<Logement> listeLogements) {
        return listeLogements.stream()
                .filter(l -> l instanceof Maison)
                .filter(l -> ((Maison) l).getPossedeJardin())
                .count();
    }

    public Map<Hote,Long> getNbLogementsParHote(ArrayList<Logement> listeLogements) {
        return listeLogements.stream()
                .collect(Collectors.groupingBy(Logement::getHote, Collectors.counting()));
    }

    // Fonctions d'affichage

    public void afficher(ArrayList<Logement> liste) {
        for (Logement logement: liste) {
            logement.afficher();
        }
    }

    public void afficherListeNomLogements(ArrayList<Logement> listeLogements) {
        ArrayList<String> listeNomsLogements = getListeNomsLogements(listeLogements);

        for (String nom: listeNomsLogements) {
            System.out.println(nom);
        }
    }

    public void afficherTarifMoyenLogements(ArrayList<Logement> listeLogements) {
        OptionalDouble tarifMoyenLogements = getTarifMoyenLogements(listeLogements);

        if (tarifMoyenLogements.isPresent()) {
            System.out.printf("%.2f€%n", tarifMoyenLogements.getAsDouble());
        }
    }

    public void afficherDelaiReponseMoyen(ArrayList<Logement> listeLogements) {
        OptionalDouble delaiDeReponseMoyenLogements = getDelaiReponseMoyen(listeLogements);

        if (delaiDeReponseMoyenLogements.isPresent()) {
            System.out.printf("%s heures%n", (int) Math.floor(delaiDeReponseMoyenLogements.getAsDouble()));
        }
    }

    public void afficherPlusGrandeCapaciteVoyageurs(ArrayList<Logement> listeLogements) {
        OptionalInt plusGrandeCapaciteVoyageurs = getPlusGrandeCapaciteVoyageurs(listeLogements);

        if (plusGrandeCapaciteVoyageurs.isPresent()) {
            System.out.printf("Plus grande capacité de voyageurs : %s%n", plusGrandeCapaciteVoyageurs.getAsInt());
        }
    }

    public void afficherTriParPrixAuMetreCarre(ArrayList<Logement> listeLogements) {
        ArrayList<Logement> logementsTriesParPrixAuMetreCarre = getLogementsTriesParPrixAuMetreCarre(listeLogements);

        for (Logement logement: logementsTriesParPrixAuMetreCarre) {
            logement.afficher();
        }
    }

    public void afficherNbMaisonsAvecJardin(ArrayList<Logement> listeLogements) {
        long nbMaisonsAvecJardin = getNbMaisonsAvecJardin(listeLogements);

        System.out.printf("Nombre de maisons avec jardin : %s%n", nbMaisonsAvecJardin);
    }

    public void afficherNbLogementsParHote(ArrayList<Logement> listeLogements) {
        Map<Hote, Long> mapNbLogementsParHote = getNbLogementsParHote(listeLogements);

        mapNbLogementsParHote.forEach((key, value) -> {
            if (value <= 1) {
                System.out.printf("%s %s : %s logement%n", key.getPrenom(), key.getNom(), value);
            } else {
                System.out.printf("%s %s : %s logements%n", key.getPrenom(), key.getNom(), value);
            }
        });
    }
}
