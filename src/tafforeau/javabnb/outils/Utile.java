package tafforeau.javabnb.outils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

// Utilisation d'un constructeur privé pour empêcher l'instanciation
// Final empêche l'héritage

public final class Utile {

    private static final SimpleDateFormat dateFormatter = new SimpleDateFormat("dd/MM/yyyy", Locale.FRANCE);

    private Utile() {
        throw new UnsupportedOperationException("Classe utilitaire");
    }

    public static Date creerDate(int jour, int mois, int annee) throws ParseException {
        return dateFormatter.parse(String.format("%s/%s/%s", jour, mois, annee));
    }

    public static String formaterDate(Date date) {
        return dateFormatter.format(date);
    }

    public static String afficherPolarite(boolean condition) {
        return condition ? "oui" : "non";
    }

    public static String afficherEtage(int numeroEtage) {
        if (numeroEtage > 1) {
            return numeroEtage + "ème étage";
        } else if (numeroEtage == 1) {
            return "1er étage";
        } else {
            return "rez-de-chaussée";
        }
    }
}
