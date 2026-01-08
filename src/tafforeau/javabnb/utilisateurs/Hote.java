package tafforeau.javabnb.utilisateurs;

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
}
