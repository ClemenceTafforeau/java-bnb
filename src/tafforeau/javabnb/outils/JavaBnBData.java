package tafforeau.javabnb.outils;

import tafforeau.javabnb.logements.Logement;
import tafforeau.javabnb.utilisateurs.Hote;

import java.util.ArrayList;

public class JavaBnBData {
    // L’unique instance créée
    private static JavaBnBData instance = new JavaBnBData();
    // Attributs de l’instance du singleton
    private ArrayList<Hote> hotes;
    private ArrayList<Logement> logements;
    // Constructeur privé
    private JavaBnBData() {
        hotes = new ArrayList<Hote>();
        logements = new ArrayList<Logement>();

        try {
            LogementsDomParser.parse("res/logements.xml", hotes, logements);
        } catch (Exception e) {
            System.out.println("Là idéalement il faudrait mettre de la fausse donnée :)");
        }
    }
    // Méthode qui permet de récupérer l’instance
    public static JavaBnBData getInstance() {
        return instance;
    }
    public ArrayList<Hote> getHotes() {
        return hotes;
    }
    public ArrayList<Logement> getLogements() {
        return logements;
    }
}
