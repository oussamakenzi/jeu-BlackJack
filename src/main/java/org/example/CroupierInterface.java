package org.example;

public interface CroupierInterface {

    void tirerCarte(PaquetCartes paquet);
    int getTotalPoints();
    boolean doitTirer();
    Carte premiereCarte();
    boolean estBust();

}
