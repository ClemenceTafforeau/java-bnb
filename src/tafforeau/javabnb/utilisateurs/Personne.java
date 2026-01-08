package tafforeau.javabnb.utilisateurs;

public class Personne {

    protected String prenom;
    protected String nom;
    protected int age;

    public Personne(String prenom, String nom, int age) {
        this.prenom = prenom;
        this.nom = nom;
        this.age = age;
    }

    public void afficher() {
        System.out.println(String.format("%s %s (%s ans)", this.prenom, this.nom, this.age));
    }
}
