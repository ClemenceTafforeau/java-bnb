package tafforeau.javabnb.utilisateurs;

public class Personne {

    private String prenom;
    private String nom;
    private int age;

    public Personne(String prenom, String nom, int age) {
        setPrenom(prenom);
        setNom(nom);
        setAge(age);
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void afficher() {
        System.out.println(String.format("%s %s (%s ans)", this.prenom, this.nom, this.age));
    }
}
