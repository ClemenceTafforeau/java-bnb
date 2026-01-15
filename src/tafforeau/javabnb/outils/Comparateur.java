package tafforeau.javabnb.outils;

public class Comparateur<T extends Comparable<T>> {

    private T element1;
    private T element2;

    public Comparateur(T pElement1, T pElement2) {
        this.element1 = pElement1;
        this.element2 = pElement2;
    }

    // - deux logements avec leurs tarif par nuits.
    //- deux personnes avec leurs ages.
    //- deux hôtes avec leurs délais de réponse.

    public T getHigher() {
        return this.element1.isHigher(this.element2) ? this.element1 : this.element2;
    }

    public T getLower() {
        return this.element1.isLower(this.element2) ? this.element1 : this.element2;
    }
}
