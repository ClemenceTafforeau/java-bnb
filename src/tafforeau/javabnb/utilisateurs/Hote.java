package tafforeau.javabnb.utilisateurs;

import java.util.Objects;

public class Hote extends Personne {

    private final int delaiDeReponse;

    public Hote(String prenom, String nom, int age, int delaiDeReponse) {

        super(prenom, nom, age);
        this.delaiDeReponse = delaiDeReponse;
    }

    public void afficher() {
        super.afficher();

        if (this.delaiDeReponse == 1) {
            System.out.printf(" qui s'engage à répondre dans l'heure%n");
        } else {
            System.out.printf(" qui s'engage à répondre dans les %s heures%n", this.delaiDeReponse);
        }
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || this.getClass() != obj.getClass()) return false;
        if (!super.equals(obj)) return false;

        Hote other = (Hote) obj;

        return Objects.equals(this.delaiDeReponse, other.delaiDeReponse);
    }
}
