package org.example;



public class Personne implements PersonneInterface {
    String userName;
    public Carte tirerCarte(PaquetCartes paquet) {
        return paquet.tirerCarte();
    }



}


