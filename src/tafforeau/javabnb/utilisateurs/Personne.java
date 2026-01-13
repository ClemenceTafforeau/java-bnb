package tafforeau.javabnb.utilisateurs;

import java.util.Objects;

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
        System.out.print(String.format("%s %s (%s ans)", this.prenom, this.nom, this.age));
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || this.getClass() != obj.getClass()) return false;
        Personne other = (Personne) obj;

        return this.age == other.age &&
                Objects.equals(this.prenom, other.prenom) &&
                Objects.equals(this.nom, other.nom);
    }
}
