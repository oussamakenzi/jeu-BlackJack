package org.example;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Random;

public class PaquetCartes {
    private static List<Carte> listeCarte;
    private Random random;

    public PaquetCartes() {
        listeCarte = new ArrayList<>();
        random = new Random();

        String[] enseignes = {"Pique", "Coeur", "Carreau", "Trèfle"};
        String[] valeurs = {"2", "3", "4", "5", "6", "7", "8", "9", "10", "Valet", "Dame", "Roi", "As"};

        for (String enseigne : enseignes) {
            for (String valeur : valeurs) {
                int valeurNumerique;
                if (valeur.equals("Valet") || valeur.equals("Dame") || valeur.equals("Roi")) {
                    valeurNumerique = 10;
                } else if (valeur.equals("As")) {
                    valeurNumerique = 11;
                } else {
                    valeurNumerique = Integer.parseInt(valeur);
                }
                listeCarte.add(new Carte(valeurNumerique, enseigne));
            }
        }
    }

    public void melanger() {
        Collections.shuffle(listeCarte);
    }

    public Carte tirerCarte() {
        if (listeCarte.isEmpty()) {
            throw new NoSuchElementException("Le paquet est vide");
        }
        return listeCarte.remove(0); // Retire et renvoie la première carte du paquet
    }
}
