package tafforeau.javabnb.utilisateurs;

public class Hote extends Personne {

    private final int delaiDeReponse;

    public Hote(String prenom, String nom, int age, int delaiDeReponse) {

        super(prenom, nom, age);
        this.delaiDeReponse = delaiDeReponse;
    }

    public void afficher() {
        if (this.delaiDeReponse == 1) {
            System.out.printf("%s %s (%s ans) qui s'engage à répondre dans l'heure%n", this.prenom, this.nom, this.age);
        }

        System.out.printf("%s %s (%s ans) qui s'engage à répondre dans les %s heures%n", this.prenom, this.nom, this.age, this.delaiDeReponse);
    }
}
