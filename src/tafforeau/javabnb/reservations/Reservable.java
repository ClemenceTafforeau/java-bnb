package tafforeau.javabnb.reservations;

public interface Reservable {

    public boolean aUneDateArriveeCorrecte();
    public boolean aUnNombreDeNuitsCorrect();
    public boolean aUnNombreDeVoyageursCorrect();
    public void afficher();
}