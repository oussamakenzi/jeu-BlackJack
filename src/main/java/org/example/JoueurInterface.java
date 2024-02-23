package org.example;

public interface JoueurInterface {
    void tirerCarte(PaquetCartes paquet);
    int getTotalPoints();
    boolean estBust();
}
